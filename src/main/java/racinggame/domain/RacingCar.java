package racinggame.domain;

public class RacingCar {
    private String carName;
    private int movesCount;

    public RacingCar(String carName) {
        this.carName = carName;
        this.movesCount = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getMovesCount() {
        return movesCount;
    }
}
