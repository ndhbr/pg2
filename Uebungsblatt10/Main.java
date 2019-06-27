public class Main {

    public static void main(String args[]) throws InterruptedException {
        //Aufgabe1();
        //Aufgabe2();
        Aufgabe3();
    }

    public static void Aufgabe1() throws InterruptedException {
        ManagedThread mt = new ManagedThread();
        mt.start();

        mt.add(new HelloWorldAction());
        mt.add(new HelloWorldAction());
        mt.add(new GoodByeWorldAction());
        mt.add(new GoodByeWorldAction());

        Thread.sleep(500);
        mt.cancel();
    }

    public static void Aufgabe2() throws InterruptedException {
        ManagedThread mt = new ManagedThread();
        mt.start();

        mt.add(new HelloWorldAction());
        mt.add(new HelloWorldAction());

        mt.add(new PushAction(mt, new HelloWorldAction()));

        mt.add(new GoodByeWorldAction());
        mt.add(new GoodByeWorldAction());

        Thread.sleep(500);
        mt.cancel();
        mt.join();
    }

    public static void Aufgabe3() throws InterruptedException {
        ManagedThread mt = new ManagedThread();
        mt.start();

        mt.add(new HelloWorldAction());
        mt.add(new HelloWorldAction());

        mt.add(new PushAction(mt, new HelloWorldAction()));

        Action a = new HelloWorldAction();
        a.setTriggerTime(System.currentTimeMillis() + 1000);
        mt.add(a);

        mt.add(new GoodByeWorldAction());
        mt.add(new GoodByeWorldAction());

        Thread.sleep(500);
        mt.cancel();

        mt.join();
    }

    public static void Aufgabe4() throws InterruptedException {
        ManagedThread mt = new ManagedThread();
        mt.start();

        mt.addListener(HelloWorldAction.class, new HelloWorldActionHandler());
        mt.addListener(Event.class, new EventHandler());

        mt.add(new HelloWorldAction());
        mt.add(new HelloWorldAction());

        mt.add(new PushAction(mt, new HelloWorldAction()));

        Action a = new HelloWorldAction();
        a.setTriggerTime(System.currentTimeMillis() + 1000);
        mt.add(a);

        mt.add(new GoodByeWorldAction());
        mt.add(new GoodByeWorldAction());

        Thread.sleep(500);
        mt.cancel();

        mt.join();
    }
}