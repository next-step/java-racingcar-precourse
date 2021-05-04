public class RetryableResult<R> {
    private boolean isSuccessfullyExecuted;
    private R result;

    public RetryableResult() {
        isSuccessfullyExecuted = false;
    }

    public boolean isSuccessfullyExecuted() {
        return isSuccessfullyExecuted;
    }

    public void setSuccessfullyExecuted(boolean successfullyExecuted) {
        isSuccessfullyExecuted = successfullyExecuted;
    }

    public R getResult() {
        return result;
    }

    public void setResult(R result) {
        this.result = result;
    }
}
