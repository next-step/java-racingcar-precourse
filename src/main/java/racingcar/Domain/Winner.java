package racingcar.Domain;

public class Winner {
    public static final boolean INIT = false;
    public static final boolean WIN = true;
    private boolean isWinner;

    public Winner() {
        this.isWinner = INIT;
    }

    public void thisCarWinner() {
        this.isWinner = WIN;
    }

    public boolean isWinner() {
        return isWinner;
    }

}
