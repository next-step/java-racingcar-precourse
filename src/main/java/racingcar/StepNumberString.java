package racingcar;

public class StepNumberString {
    String stepNumberString;

    public StepNumberString(String stepNumberString) {
        this.stepNumberString = stepNumberString;
    }

    public boolean isCollectStepNumber() throws NumberFormatException {
        Integer.parseInt(stepNumberString);

        return true;
    }

    public int getStepNumber() throws NumberFormatException {
        return Integer.parseInt(stepNumberString);
    }
}
