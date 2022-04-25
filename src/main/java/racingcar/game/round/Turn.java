package racingcar.game.round;


import camp.nextstep.edu.missionutils.Randoms;

public class Turn {

    private static final int MIN = 0;
    private static final int MAX = 9;
    private static final int CRITERION = 4;

    public static Type progress() {
        if (random() >= CRITERION) {
            return Type.GO;
        }

        return Type.STOP;
    }

    private static int random() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }

    public enum Type {

        GO,
        STOP;

    }

}
