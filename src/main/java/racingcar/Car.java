package racingcar;

import static racingcar.Constant.CAR_SHOW_DISTANCE_MARK;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
    final CarName carName;
    final Distance distance;

    public Car(String carName, int distance) throws IllegalArgumentException {
        this.carName = new CarName(carName);
        this.distance = new Distance(distance);
    }

    public String getCarName() {
        return carName.carName;
    }

    public Distance getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Car obj) {
        return getDistance().compareTo(obj.getDistance());
    }

    public Car ifSameDistanceReturn(Distance winnerDistance) {
        if (getDistance().equals(winnerDistance)) {
            return this;
        }
        return null;
    }

    public void printCarStatus() {
        System.out.print(carName + " : ");
        for (int i = 0; i < distance.getDistance(); i++) {
            System.out.print(CAR_SHOW_DISTANCE_MARK);
        }
        System.out.println();
    }

    public void moveRandomNumber() {
        int randomNumber = setRandomNumber();
        move(randomNumber);
    }

    public int setRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            distance.addMove();
        }
    }
}
