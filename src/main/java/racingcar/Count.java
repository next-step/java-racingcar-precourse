package racingcar;

public class Count {

    private int count;

    public Count(String count) {
        validateIsNumber(count);
        this.count = Integer.parseInt(count);
        validateCount(this.count);
    }

    public int getCount() {
        return count;
    }

    private void validateCount(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(Message.ERROR.message("시도 횟수는 1 이상이여야 합니다."));
        }
    }

    private void validateIsNumber(String count) {
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR.message("시도 횟수는 숫자만 가능합니다."));
        }
    }


}
