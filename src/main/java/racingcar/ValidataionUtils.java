package racingcar;

public class ValidataionUtils {
    public static final int MIN_GAME_CNT = 1;

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
