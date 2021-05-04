public class RetryHelper<T, R> {
    public static final int DEFAULT_RETRY_LIMIT_COUNT = 5;
    Retryable<T, R> retryable;
    int retryLimitCount;

    public RetryHelper(Retryable<T, R> retryable) {
        this.retryable = retryable;
        retryLimitCount = DEFAULT_RETRY_LIMIT_COUNT;
    }
    public RetryHelper(Retryable<T, R> retryable, int retryLimitCount) {
        this.retryable = retryable;
        this.retryLimitCount = retryLimitCount;
    }

    public void setRetryLimitCount(int retryLimitCount) {
        this.retryLimitCount = retryLimitCount;
    }

    R execute() throws Exception {
        return this.execute(null);
    }

    R execute(T t) throws Exception {
        RetryableResult<R> retryableResult = new RetryableResult<>();
        boolean isSuccessfullyExecuted = false;
        int trycount = 0;
        do {
            retryableResult = executeRetryable(t);
        } while (!retryableResult.isSuccessfullyExecuted() && trycount++ < retryLimitCount);
        if (trycount > retryLimitCount) throw new Exception("재시도 횟수를 초과하였습니다");
        return retryableResult.getResult();
    }

    private RetryableResult<R> executeRetryable(T t) {
        RetryableResult<R> retryableResult = new RetryableResult<>();
        try {
            retryableResult.setResult(retryable.execute(t));
            retryableResult.setSuccessfullyExecuted(true);
        } catch (Exception e) {
            retryable.onError(e);
            retryableResult.setSuccessfullyExecuted(false);
        }
        return retryableResult;
    }


}
