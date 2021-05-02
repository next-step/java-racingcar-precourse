public class TrialCount {
    private static final String NOTIFY_INVALID_TRIAL_COUNT_EXCEPTION_MSG = "시도 횟수는 숫자이어야 합니다.";
    private static final String NOTIFY_INVALID_TRIAL_COUNT_CONSOLE_MSG = NOTIFY_INVALID_TRIAL_COUNT_EXCEPTION_MSG + "(입력값: %s)";
    private static final int INVALID_TRIAL_COUNT = -1;

    private int trialCount;

    public TrialCount(String trialCountString) {
        try {
            this.trialCount = Integer.parseInt(trialCountString);
        } catch (NumberFormatException e) {
            this.trialCount = INVALID_TRIAL_COUNT;

            System.out.println(String.format(NOTIFY_INVALID_TRIAL_COUNT_CONSOLE_MSG, trialCountString));
            throw e;
        }
    }

    public int getTrialCount() {
        if (this.trialCount == INVALID_TRIAL_COUNT) {
            throw new NumberFormatException(NOTIFY_INVALID_TRIAL_COUNT_EXCEPTION_MSG);
        }

        return this.trialCount;
    }
}