import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ManagedThread extends Thread {

    private final Object sema = new Object();

    private List<Event> queue;
    private HashMap<Class<? extends Event>,
        List<EventListener<? extends Event>>> listeners;
    private boolean isCancelled;

    public ManagedThread() {
        queue = new LinkedList<>();
        listeners = new HashMap<>();
        isCancelled = false;
    }

    public void run() {
        synchronized(sema) {
            try {
                while(!isCancelled) {
                    long currentTime = System.currentTimeMillis();
                    int i;

                    for(i = 0; i < queue.size();) {
                        Event a = queue.get(i);

                        if(a.getTriggerTime() <= currentTime) {
                            if(a instanceof Action) {
                                Action tmpAction = (Action) a;
                                tmpAction.execute();
                            }

                            notifyListeners(a);
                            queue.remove(i);
                        } else {
                            currentTime = a.getTriggerTime();
                            i++;
                        }
                    }

                    long timeout = currentTime - System.currentTimeMillis();

                    if(queue.isEmpty())
                        sema.wait();
                    else if(timeout > 0)
                        sema.wait(timeout);
                }
            } catch(InterruptedException e) {
                System.out.println("Interrupted.");
                throw new RuntimeException();
            }
        }
    }

    public <T extends Event> void addListener(Class<T> eventClass,
        EventListener<? super T> listener) {

        if(!listeners.containsKey(eventClass)) {
            listeners.put(eventClass, new ArrayList<>());
        }

        List<EventListener<? extends Event>> list = listeners.get(eventClass);
        list.add(listeners);
    }

    private <T extends Event> void notifyListeners(T event) {
        Class <?> cls = event.getClass();

        do {
            List<EventListener<? extends Event>> elisteners = listeners.get(cls);

            if(elisteners != null) {
                for(EventListener<? extends Event> listener :
                    elisteners) {

                    EventListener<T> l = (EventListener<T>) listener;
                    l.update(event);
                }
            }

            cls = cls.getSuperclass();
        } while(!cls.equals(Event.class.getSuperclass()));
    }

    public void add(Action action) {
        synchronized(sema) {
            queue.add(action);
            sema.notify();
        }
    }

    public void cancel() {
        this.isCancelled = true;

        synchronized(sema) {
            sema.notify();
        }
    }
}