package model;

public class Trial {

    private int trials;

    public Trial(int trials) {
        this.trials = trials;
    }

    public int getTrials() {
        return trials;
    }

    public void endOneTrial() {
        this.trials -= 1;
    }

    public boolean isContinued() {
        return this.trials > 0;
    }

    public static Trial getTrial(String input) {
        try {
            int trials = Integer.parseInt(input);
            Trial.checkTrialBoundary(trials);

            return new Trial(trials);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 양식입니다.");
        }
    }

    public static void checkTrialBoundary(int trial) {
        if (trial < 1 || trial > 100) {
            throw new IllegalArgumentException("[ERROR] 1~100 범위 내의 숫자를 입력해주세요.");
        }
    }
}
