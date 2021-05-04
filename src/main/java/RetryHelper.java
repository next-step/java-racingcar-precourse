public class RetryHelper<T, R> {
    Retryable<T, R> retryable;
    int retryLimitCount;

    public RetryHelper(Retryable<T, R> retryable) {
        this.retryable = retryable;
        retryLimitCount = 5;
    }
    public RetryHelper(Retryable<T, R> retryable, int retryLimitCount) {
        this.retryable = retryable;
        this.retryLimitCount = retryLimitCount;
    }

    public void setRetryLimitCount(int retryLimitCount) {
        this.retryLimitCount = retryLimitCount;
    }

    R executeWithRetry() throws Exception {
        return this.executeWithRetry(null);
    }

    R executeWithRetry(T t) throws Exception {
        RetryableResult<R> retryableResult = new RetryableResult<>();
        boolean isSuccessfullyExecuted = false;
        int trycount = 0;
        do {
            retryableResult = executeRetryable(t);
        } while (!retryableResult.isSuccessfullyExecuted() && trycount++ < retryLimitCount);
        if (trycount < retryLimitCount) throw new Exception("재시도 횟수를 초과하였습니다");
        return retryableResult.getResult();
    }

    private RetryableResult<R> executeRetryable(T t) throws Exception {
        RetryableResult<R> retryableResult = new RetryableResult<>();
        retryableResult.setResult(retryable.execute(t));
        return retryableResult;
    }


}
