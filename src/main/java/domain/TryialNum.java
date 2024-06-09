package domain;

public class TryialNum {

    private final int trialNum;

    public TryialNum(final String trialNum) {
        isNaturalNumberValidate(trialNum);
        this.trialNum = convertStringToInt(trialNum);
    }

    private void isNaturalNumberValidate(String trialNum) {
        if (!trialNum.matches("^[1-9]\\d*$")){
            throw new IllegalArgumentException("이동할 횟수는 자연수여야 한다.");
        }
    }

    private int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }

    public int getTrialNum() {
        return trialNum;
    }
}
