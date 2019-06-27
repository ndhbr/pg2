public interface EventListener<T> extends Event {
    void update(T event);
}