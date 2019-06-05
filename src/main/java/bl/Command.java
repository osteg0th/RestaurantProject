package bl;

public interface Command<T> {
    T execute();
}
