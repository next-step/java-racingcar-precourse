package racingcar;

public class ProgressStep {
    StepNumberString stepNumberString;

    public ProgressStep(StepNumberString stepNumberString) {
        this.stepNumberString = stepNumberString;
    }

    public boolean isCollectStepNumber() {
        try {
            stepNumberString.isCollectStepNumber();
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }

        return true;
    }

    public int progressStopToInt() {
        return stepNumberString.getStepNumber();
    }
}
