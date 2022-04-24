package racingcar;

public class ValidataionUtils {
    public static final int MIN_CAR_NUM = 2;
    public static final int MAX_CAR_NAME_SIZE = 5;
    public static final int MIN_GAME_CNT = 1;
    public static boolean validCarNames(String inputCarNames) {
        if (inputCarNames == null || inputCarNames.isEmpty()) {
            throw new IllegalArgumentException();
        }
        String[] carNames = inputCarNames.split(",");
        if (carNames.length < MIN_CAR_NUM) {
            throw new IllegalArgumentException();
        }

        for (String name : carNames) {
            validCarName(name);
        }

        return true;
    }

    private static void validCarName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (carName.length() > MAX_CAR_NAME_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean validPlayGameCnt(String gameCntStr) {
        try {
            int gameCnt = Integer.parseInt(gameCntStr);
            if (gameCnt < MIN_GAME_CNT) {
                throw new IllegalArgumentException();
            }
            return true;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
