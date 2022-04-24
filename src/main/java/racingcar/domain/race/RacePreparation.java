package racingcar.domain.race;

import racingcar.Constant;
import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class RacePreparation {
    public String[] generateRaceCars(Scanner scanner) {
        String input = scanner.nextLine();

        return Stream.of(input.split(Constant.SEPARATOR))
                .map(s -> s.replaceAll(Constant.BLANK, Constant.EMPTY_NAME))
                .toArray(String[]::new);
    }

    public String getRaceCount(Scanner scanner) {
        return scanner.nextLine();
    }

    public List<Car> carRegistration(String[] allCarName) {
        List<Car> cars = new ArrayList<>();

        for (String carName : allCarName) {
            Car car = new Car(carName);
            cars.add(car);
        }

        return cars;
    }

}
