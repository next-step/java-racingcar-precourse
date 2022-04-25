package racingcar.domain;

public class RaceProgress {

    public int progress;
    public static final int PROGRESS_CONDITION = 4;

    public int getProgress() {
        return progress;
    }

    public void forwardProgress(int number) {
        if (number >= PROGRESS_CONDITION) this.progress++;
    }

}