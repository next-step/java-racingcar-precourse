package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.exception.domain.CarsException;
import racingcar.exception.domain.DuplicateCarsException;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final String WINNER_NAME_DELIMITER = ",";
    private static final int MIN_CAR_COUNT = 2;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final String SPACING_WARD = "\n";

    private List<Car> cars;

    public Cars(String stringCars) {
        String[] splitCars = splitCars(stringCars);
        validateNumberOfCars(splitCars);
        createCars(splitCars);
    }

    public Cars(List<Car> objectCars) {
        this.cars = objectCars;
    }

    public String printCars() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            car.move(randomNumber);
            String result = car.print() + SPACING_WARD;
            stringBuilder.append(result);
        }
        return stringBuilder.toString();
    }

    public int getSize() {
        return cars.size();
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    private String[] splitCars(String stringCars) {
        String[] splitCars = stringCars.split(CAR_NAME_DELIMITER);
        return splitCars;
    }

    private void createCars(String[] splitCars) {
        List<Car> cars = new ArrayList<>();

        for (String carName : splitCars) {
            validateDuplication(cars, carName);
            cars.add(new Car(new CarName(carName)));
        }

        this.cars = cars;
    }

    private void validateNumberOfCars(String[] splitCars) {
        if (splitCars.length < MIN_CAR_COUNT) {
            throw new CarsException();
        }
    }

    private void validateDuplication(List<Car> cars, String carName) {
        for (Car car : cars) {
            compareCar(car, carName);
        }
    }

    private void compareCar(Car car, String carName) {
        if (car.getName().equals(carName)) {
            throw new DuplicateCarsException();
        }
    }

    public String getCarNames() {
        List<String> names = new ArrayList<>();
        for (Car car : cars) {
            names.add(car.getName());
        }
        return String.join(WINNER_NAME_DELIMITER, names);
    }


}
