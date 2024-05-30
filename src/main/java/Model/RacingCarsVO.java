package Model;

public class RacingCarsVO {
    private String carName;
    private int move;

    public RacingCarsVO(String carName) {
        this.carName = carName;
        this.move = 0;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

}
