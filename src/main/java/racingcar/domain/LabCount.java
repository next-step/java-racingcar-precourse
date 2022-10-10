package racingcar.domain;

public class LabCount {

    private final int count;

    public LabCount(String count) {
        validate(count);
        this.count = Integer.parseInt(count);
    }

    private void validate(String count) {
        if (Integer.parseInt(count) < 1) {
            throw new IllegalArgumentException("[ERROR] 0 이하의 정수는 입력할 수 없습니다.");
        }
    }

    public int getCount() {
        return count;
    }
}
