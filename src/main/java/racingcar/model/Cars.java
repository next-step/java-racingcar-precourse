package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(Names names) {
        cars = new ArrayList<>();
        for (Name name : names.getNames()) {
            cars.add(Car.create(name));
        }
    }

    private Cars(List<Car> cars) {
        this.cars = new ArrayList<>();
        this.cars.addAll(cars);
    }

    public static Cars create(Names names) {
        return new Cars(names);
    }

    public static Cars valueOf(List<Car> cars) {
        return new Cars(cars);
    }

    public void move() {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(Car.MIN_NUMBER, Car.MAX_NUMBER));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public Position getMaxPosition() {
        Position maxPosition = Position.valueOf(0);
        for (Car car : cars) {
            maxPosition = maxPosition.getMorePosition(car.getPosition());
        }

        return maxPosition;
    }

    public Cars getParticularPosition(Position position) {
        List<Car> pickCars = new ArrayList<>();
        for (Car car : cars) {
            addEqualPositionCar(position, pickCars, car);
        }

        return Cars.valueOf(pickCars);
    }

    private void addEqualPositionCar(Position position, List<Car> list, Car car) {
        if (position.equals(car.getPosition())) {
            list.add(car);
        }
    }

}
