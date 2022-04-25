package racingcar.model;

import racingcar.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racer {

    // TODO: 자동차선택(설정) 및 이동, 우승자선택
    private int numberOfRaces;
    private ArrayList<Car> cars = new ArrayList<>();

    public Racer(List<String> cars) {
        cars.forEach(car -> this.cars.add(new Car(car)));
    }

    public ArrayList<Car> getCars() {
        return this.cars;
    }

    public void raceCars() {
        cars.forEach(Car::movePosition);
        Output.printResult(new ArrayList<>(cars.stream().map(Car::getCurrentResult).collect(Collectors.toList())));
    }

    public void pickWinner() {
        int maxPostion = cars.stream().mapToInt(Car::getPosition).max().getAsInt();
        Output.printWinner(new ArrayList<>(cars.stream().filter(car -> car.getPosition() == maxPostion).map(Car::getName).collect(Collectors.toList())));
    }
}
