package racinggame;

/**
 * Name : Round <br/>
 * Description : 레이싱 게임 라운드
 */
public class Round {
    private int count;

    public Round(int count) {
        if (count == 0) {
            throw new IllegalArgumentException("시도할 횟수는 0보다 커야 합니다.");
        }
        this.count = count;
    }

    public Round() {
        this(0);
    }

    public int getCount() {
        return this.count;
    }
}
