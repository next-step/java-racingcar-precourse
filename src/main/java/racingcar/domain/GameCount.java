package racingcar.domain;

public class GameCount {
    public static final String INPUT_ERROR_COUNT = "시도할 횟수는 1이상의 숫자만 가능합니다.";
    public static final int END_CONDITION = 0;

    private int count;

    public GameCount(String countString) {
        isValidCount(countString);
        this.count = Integer.parseInt(countString);
    }

    public boolean isContinue() {
        return count != END_CONDITION;
    }

    public void playCount() {
        count--;
    }

    private void isValidCount(String countString) {
        int count = parseCount(countString);
        if (count <= 0)
            throw new IllegalArgumentException(INPUT_ERROR_COUNT);
    }

    private int parseCount(String countString) {
        try {
            return Integer.parseInt(countString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ERROR_COUNT);
        }
    }
}
