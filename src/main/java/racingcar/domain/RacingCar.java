package racingcar.domain;

public class RacingCar {
    private int carPosition = 0;
    private final String carName;

    public RacingCar(String carName) {
        this.carName = carName;
    }

    public void move(MovingCheck movingCheck) {
        if(movingCheck.isMovable()) {
            this.carPosition++;
        }
    }

    public int getStatus() {
        return this.carPosition;
    }

    public String getCarName() {
        return this.carName;
    }
}
