package racingcar;

import static racingcar.Constant.STRING_JOIN_DELIMITER;
import static racingcar.Constant.WINNER_PRE_MSG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Cars {
    final List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    List<Car> getCars() {
        return cars;
    }

    private Iterator<Car> getIterator(Cars cars) {
        return cars.getCars().iterator();
    }

    public int size() {
        return cars.size();
    }

    public void addCar(Car car) {
        if (car != null) {
            cars.add(car);
        }
    }

    public Distance winnerDistance() {
        Collections.sort(cars);

        return cars.get(cars.size() - 1).getDistance();
    }

    public Cars winnerCars(Distance winnerDistance) {
        Cars winnerCars = new Cars();
        for (Car car : cars) {
            winnerCars.addCar(car.ifSameDistanceReturn(winnerDistance));
        }
        return winnerCars;
    }

    public void printWinnerCars() {
        Cars winnerCars = winnerCars(winnerDistance());
        Iterator<Car> iterator = getIterator(winnerCars);
        String[] winnerNames = new String[winnerCars.size()];

        int i = 0;
        while (iterator.hasNext()) {
            Car car = iterator.next();
            winnerNames[i++] = car.getCarName();
        }

        System.out.print(WINNER_PRE_MSG);
        System.out.println(String.join(STRING_JOIN_DELIMITER, winnerNames));
        System.out.println();
    }

    public void printCarsStatus() {
        Iterator<Car> iterator = getIterator(this);
        System.out.println();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            car.printCarStatus();
        }
    }

    public void moveCars() {
        Iterator<Car> iterator = getIterator(this);
        while (iterator.hasNext()) {
            Car car = iterator.next();
            car.moveRandomNumber();
        }
    }
}