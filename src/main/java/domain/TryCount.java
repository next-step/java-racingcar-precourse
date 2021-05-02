package domain;

public class TryCount {
    private static final int POSITIVE_NUMBER_CONDITION = 1;

    private int count;

    public TryCount(String tryCount) {
        this(Integer.parseInt(tryCount));
    }

    public TryCount(int count) {
        this.count = count;

        if (count < POSITIVE_NUMBER_CONDITION) {
            throw new IllegalArgumentException("움직이는 조건은 양수여야 합니다.");
        }
    }

    public int getCount() {
        return count;
    }
}
