package racingcar.damain;

import java.util.List;

public class Car implements Comparable<Car> {

    private CarName carName;
    private Position position;

    public String getCarName() {
        return carName.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.position = new Position();
    }

    public void tryoutMove() {
        position.tryoutMove();
    }

    @Override
    public int compareTo(Car car) {
        return getPosition() - car.getPosition();
    }

    public void showRace() {
        System.out.println(carName.getName() + " : " + position.printMonitor());
    }

    public List<Car> addWinnerCar(List<Car> cars, int position) {
        if (getPosition() == position)
            cars.add(this);
        return cars;
    }
}
