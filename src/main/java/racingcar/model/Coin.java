package racingcar.model;

import static racingcar.constant.RacingCarGameErrorMessage.ERROR_COIN_NEGATIVE_MESSAGE;

public class Coin {

    private static final int GAME_END_CONDITION = 0;
    private static final int ZERO = 0;

    private int coin;

    public Coin(int coin) {
        validatePositive(coin);
        this.coin = coin;
    }

    public void useCoin() {
        this.coin--;
    }

    public int get() {
        return this.coin;
    }

    public boolean isContinue() {
        return this.coin != GAME_END_CONDITION;
    }

    private static void validatePositive(int coin) {
        if (coin < ZERO) throw new IllegalArgumentException(ERROR_COIN_NEGATIVE_MESSAGE);
    }
}
