public interface Retryable<T, R> {
    R execute(T t) throws Exception;

    void onError(Exception e);
}
