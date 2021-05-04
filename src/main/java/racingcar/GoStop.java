package racingcar;

import java.util.Random;

public enum GoStop {
    GO, STOP;

    private static Random random = new Random();

    public static GoStop checkGo(int no) {
        if (no > 9 || no < 0) {
            throw new IllegalArgumentException("전진하는 조건은 0에서 9사이의 수만 입력할 수 있습니다.");
        }

        if (no < 4) {
            return STOP;
        }

        return GO;
    }

    public static GoStop getRandomNumber() {
        return checkGo(random.nextInt(10));
    }

    public boolean isGo() {
        return GoStop.GO == this;
    }

    public boolean isStop() {
        return GoStop.STOP == this;
    }
}
