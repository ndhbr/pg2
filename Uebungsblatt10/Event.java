public abstract class Event {
    private long triggerTime;

    public Event() {

    }

    public Event(long triggerTime) {
        this.triggerTime = triggerTime;
    }

    public long getTriggerTime() {
        return this.triggerTime;
    }

    public void setTriggerTime(long triggerTime) {
        this.triggerTime = triggerTime;
    }
}