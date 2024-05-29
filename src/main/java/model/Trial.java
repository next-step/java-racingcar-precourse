package model;

public class Trial {

    private int trials;

    public Trial(int trials) {
        this.trials = trials;
    }

    public int getTrials() {
        return trials;
    }

    public void setTrials(int trials) {
        this.trials = trials;
    }

    public static void checkTrialBoundary(int trial) {
        if (trial < 1 || trial > 100) {
            throw new IllegalArgumentException("[ERROR] 1~100 범위 내의 숫자를 입력해주세요.");
        }
    }
}
