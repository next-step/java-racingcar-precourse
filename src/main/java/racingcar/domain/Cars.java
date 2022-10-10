package racingcar.domain;

import racingcar.ui.ConsoleMessage;
import racingcar.ui.ConsoleView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    private static final String DELIMITER = ",";
    private static final String PROGRESS_BAR = "-";

    private final List<Car> cars;

    public Cars(String names) {
        verifyNames(names);
        cars = toList(names);
    }

    Car getCar(int index) {
        return cars.get(index);
    }

    public int getCarCount() {
        return cars.size();
    }

    private void verifyNames(String names) {
        if (isValid(names)) {
            throw new IllegalArgumentException(ConsoleMessage.CARS_INVALID_NAMES_ERROR.getMessage());
        }
        if (isDuplicatedNames(names)) {
            throw new IllegalArgumentException(ConsoleMessage.CARS_DUPLICATED_NAMES_ERROR.getMessage());
        }
    }

    private boolean isValid(String names) {
        return !names.matches("([\\w]+,)*([\\w]+,[\\w]+)");
    }

    private boolean isDuplicatedNames(String names) {
        String[] allNames = names.split(DELIMITER);
        Set<String> uniqueNames = new HashSet<>();
        for (String name : allNames) {
            uniqueNames.add(name.trim());
        }
        return allNames.length != uniqueNames.size();
    }

    private List<Car> toList(String names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names.split(DELIMITER)) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    public void control() {
        for (Car car : cars) {
            car.control(Engine.getControlType());
            printPosition(car);
        }
        ConsoleView.newLine();
    }

    private void printPosition(Car car) {
        ConsoleView.printMessage("%s : %s%n", car.getCarName(), getPosition(car));
    }

    private String getPosition(Car car) {
        StringBuilder progress = new StringBuilder();
        for (int i = 0; i < car.getCarPosition(); i++) {
            progress.append(PROGRESS_BAR);
        }
        return progress.toString();
    }

    public Winners getWinners() {
        return new Winners(cars);
    }
}
