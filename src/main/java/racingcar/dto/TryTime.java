package racingcar.dto;

public class TryTime {
    private final int value;

    public TryTime(String tryTime) {
        this.value = convertTryTime(tryTime);
        validateTryTime(this.value);
    }

    private int convertTryTime(String tryTime) {
        if (tryTime == null || tryTime.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 시도할 회수가 없습니다.");
        }

        try{
            return Integer.parseInt(tryTime);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
    }

    private void validateTryTime(int tryTime) {
        if (tryTime <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도할 회수는 1이상이어야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }

}
