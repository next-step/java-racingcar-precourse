package racingcar.domain;

import racingcar.Constant;

import java.util.Objects;

public class Car {
    private StringBuilder showCarDistance;

    private String carName;
    private int position = 0;

    public Car(String carName){
        if(isOverFive(carName)){
            throw new IllegalArgumentException(Constant.ERROR_CAR_NAME_LENGTH);
        }
        this.carName = carName;
    }

    /**
     * 각 자동차의 이름을 정하고, 1~5자
     * 사용자의 이동 횟수를 입력받는다.
     * @param carName
     * @param position
     */
    public Car(String carName, int position) {
        if(isOverFive(carName)){
            throw new IllegalArgumentException(Constant.ERROR_CAR_NAME_LENGTH);
        }
        this.position = position;
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }


    private boolean isOverFive(String carName) {
        return carName.length() >= Constant.MIN_CAR_NAME_LENGTH && carName.length() > Constant.MAX_CAR_NAME_LENGTH;
    }

    public boolean isMove(MovingStrategy movingStrategy){
        if(movingStrategy.movable()){
            position += 1;
            return true;
        }
        return false;
    }

    public int getDistance() {
        return this.position;
    }

    public String showCarDistance() {
        showCarDistance = new StringBuilder();
        for (int i = 0; i < position; i++) {
            showCarDistance.append(Constant.FORWARD_SIGN);
        }
        return showCarDistance.toString();
    }

    public boolean isWinner(int maxPosition) {
        return maxPosition == getDistance();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(showCarDistance, car.showCarDistance) && Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(showCarDistance, carName, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "showCarDistance=" + showCarDistance +
                ", carName='" + carName + '\'' +
                ", position=" + position +
                '}';
    }
}
