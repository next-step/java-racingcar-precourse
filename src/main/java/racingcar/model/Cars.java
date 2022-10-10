package racingcar.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = mapCars(carNames);
    }

    private static List<Car> mapCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            Car car = new Car(new CarName(carName));
            cars.add(car);
        }
        return cars;
    }

    public int length() {
        return cars.size();
    }

    public void moveAll() {
        for (Car car : cars) {
            car.drive();
        }
    }

    public Collection<Car> getCars() {
        return this.cars;
    }

    public List<Car> getWinner() {
        int farthestPosition = findFarthestPosition();
        List<Car> winnerCars = new ArrayList<>();
        for (Car car : cars) {
            gatherWinnerCar(farthestPosition, winnerCars, car);
        }
        return winnerCars;
    }

    private static void gatherWinnerCar(int farthestPosition, List<Car> winnerCars, Car car) {
        if (car.getPosition() == farthestPosition) {
            winnerCars.add(car);
        }
    }

    private int findFarthestPosition() {
        cars.sort((car1, car2) -> car2.getPosition() - car1.getPosition());
        return cars.get(0).getPosition();
    }
}
