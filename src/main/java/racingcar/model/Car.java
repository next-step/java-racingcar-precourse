package racingcar.model;

import racingcar.constant.ErrorMessage;

public class Car {

    private String name;

    private final DrivingDistance drivingDistance;

    public Car() {
        this.drivingDistance = new DrivingDistance();
    }

    public Car(String name) {
        this.setName(name);
        this.drivingDistance = new DrivingDistance();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_CREATION_CAR_NAME_MESSAGE);
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_CAR_NAME_MESSAGE);
        }
    }

    public DrivingDistance getDrivingDistance() {
        return this.drivingDistance;
    }

    public void move(int randomNumber) {
        validateMoveNumber(randomNumber);
        if (randomNumber >= 4) {
            this.drivingDistance.add();
        }
    }

    private void validateMoveNumber(int randomNumber) {
        if (randomNumber > 9 || randomNumber < 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VAILD_NUMBER_MESSAGE);
        }
    }

}
