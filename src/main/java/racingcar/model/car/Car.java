package racingcar.model.car;

import racingcar.type.CarMovingStatusType;

public class Car {

    private final CarName carName;
    private int distance = 0;

    public Car(CarName carName) {
        validateIfNull(carName);
        this.carName = carName;
    }

    public void changeDistance(CarBehavior carBehavior) {
        if (CarMovingStatusType.isMovingType(carBehavior.getMovingStatusType())) {
            distance++;
        }
    }

    public String getCurrentStatusToString() {
        StringBuilder movingMessage = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            movingMessage.append("-");
        }

        return carName.getName() + " : " + movingMessage;
    }

    private void validateIfNull(CarName carName) {
        if (carName == null) {
            throw new IllegalArgumentException("자동차의 이름은 필수값입니다.");
        }
    }

    public int getDistanceCount() {
        return distance;
    }

    public String getCarName() {
        return this.carName.getName();
    }

}
