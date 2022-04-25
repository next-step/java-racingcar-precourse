package racingcar;

public class LapCount {
    private final String ERROR_LAB_COUNT_ONLY_POSITIVE_INTEGER = "[ERROR] 랩 횟수는 양의 정수만 가능합니다.";

    private final int intLapCount;

    private LapCount(String userInputCount) {
        validateInputCount(userInputCount);
        this.intLapCount = Integer.parseInt(userInputCount);
    }

    private void validateInputCount(String userInputCount) {
        int input;
        try {
            input = Integer.parseInt(userInputCount);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_LAB_COUNT_ONLY_POSITIVE_INTEGER);
        }

        if (input < 1) {
            throw new IllegalArgumentException(ERROR_LAB_COUNT_ONLY_POSITIVE_INTEGER);
        }
    }

    public static LapCount createLapCount(String userInputCount) {
        return new LapCount(userInputCount);
    }

    public int getLapCount() {
        return this.intLapCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LapCount lapCount = (LapCount) o;

        return intLapCount == lapCount.intLapCount;
    }

    @Override
    public int hashCode() {
        return intLapCount;
    }
}
