package racingcar;

public class Counter {
    private int count;

    public Counter(final int count) {
        validate(count);
        this.count = count;
    }

    private void validate(final int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("시도 회수는 0보다 커야합니다.");
        }
    }

    public boolean isFinish() {
        return (count == 0);
    }

    public void countDown() {
        if (count <= 0) {
            throw new IllegalStateException("이미 모두 카운트되었습니다.");
        }
        count--;
    }
}
