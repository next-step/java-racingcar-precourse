package racingcar.vo;

import racingcar.constant.MoveStatus;

public class RacingCar {

    private final String carName;
    private int location;

    public RacingCar(String carName) {
        this.carName = carName;
        this.location = 0;
    }

    public String getCarName() {
        return carName;
    }

    public void updateLocation(MoveStatus moveStatus) {
        if (MoveStatus.FORWARD.equals(moveStatus)) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }
}
