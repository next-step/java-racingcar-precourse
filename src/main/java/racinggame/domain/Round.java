package racinggame.domain;

/**
 * Name : Round <br/>
 * Description : 레이싱 게임 라운드
 */
public class Round {
    public static final int ZERO = 0;
    private int count;

    public Round(int count) {
        if (count == 0) {
            System.out.println(ErrorCode.ROUND_COUNT_ZERO.getMessage());
            throw new IllegalArgumentException(ErrorCode.ROUND_COUNT_ZERO.getMessage());
        }
        this.count = count;
    }

    public Round() {
        this(ZERO);
    }

    public int getCount() {
        return this.count;
    }

    public void decreaseCount() {
        if (getCount() > ZERO) {
            this.count -= 1;
        }
    }

    public boolean isRemainRound() {
        return this.count > ZERO;
    }
}
