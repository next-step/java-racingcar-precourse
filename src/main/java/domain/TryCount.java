package domain;

public class TryCount {
    private int count;

    public TryCount(String tryCount) {
        this(Integer.parseInt(tryCount));
    }

    public TryCount(int count) {
        this.count = count;

        if(count < 1) {
            throw new IllegalArgumentException("움직이는 조건은 양수여야 합니다.");
        }
    }

    public int getCount() {
        return count;
    }
}
