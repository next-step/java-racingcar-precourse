package racinggame.car;

public class GameCount {
    int count;

    public GameCount() {
        this.count = 0;
    }

    public GameCount(String count) {
        validateGameCount(count);
        this.count = Integer.parseInt(count);
    }

    private void validateGameCount(String count) {
        if (!count.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
        }
        if (Integer.parseInt(count) < 1) {
            throw new IllegalArgumentException("입력값은 1 이상입니다.");
        }
        if (Integer.parseInt(count) > 100) {
            throw new IllegalArgumentException("입력값은 100 이하입니다.");
        }
    }

    public void set(String count) throws Exception {
        validateGameCount(count);
        this.count = Integer.parseInt(count);
    }

    public void countDown() {
        this.count--;
    }

    public boolean isNoneZero() {
        if (count == 0) {
            return false;
        }
        return true;
    }
}
