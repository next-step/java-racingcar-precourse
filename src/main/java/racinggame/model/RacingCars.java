package racinggame.model;

import racinggame.exception.ValidationException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
    private final List<Car> racingCars;

    public RacingCars(List<String> racingCars) {
        if (!validateInput(racingCars)) {
            throw new ValidationException();
        }
        this.racingCars = createCar(racingCars);
    }

    private List<Car> createCar(List<String> racingCars) {
        List<Car> carList = new ArrayList<>();
        for (String name : racingCars) {
            carList.add(new Car(name));
        }
        return carList;
    }

    private boolean validateInput(List<String> racingCars) {
        return racingCars.size() > 0;
    }

    public String proceedRace() {
        StringBuilder sb = new StringBuilder();
        for (Car car : racingCars) {
            car.moving();
            sb.append(car.getCarName() + " : ");
            sb.append(car.displayDistance(car));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String getWinner() {
        List<String> winnerList = new ArrayList<>();
        for (Car car : racingCars) {
            compareDistance(Collections.max(racingCars).getDistance(), car, winnerList);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자는 ")
                .append(String.join(",", winnerList))
                .append(" 입니다.");

        return sb.toString();
    }

    private void compareDistance(int distance, Car car, List<String> winnerList) {
        if (distance == car.getDistance()) {
            winnerList.add(car.getCarName());
        }
    }

}
