package racingcar.feature;

public class GameCount {
    private final int count;

    public GameCount(String input) {
        this.count = parseNumber(input);
    }

    public int getCount() {
        return this.count;
    }

    private int parseNumber(String count) {
        try {
            return Integer.parseInt(count);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 시도할 횟수를 정확히 입력해 주세요");
        }
    }
}
