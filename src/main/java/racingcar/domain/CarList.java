package racingcar.domain;
import racingcar.Utils;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    List<Car> carList;
    Distance championDistance;

    public CarList() {
        carList = new ArrayList<>();
        championDistance = new Distance();
    }

    public CarList(String[] carList) {
        this.carList = new ArrayList<>();
        this.championDistance = new Distance();

        for (String s : carList) {
            this.carList.add(new Car(s));
        }

    }

    public void race() {
        for (Car car : carList) {
            car.move();
            System.out.println(car.getName() + " : " + Utils.getDistanceDash(car.getDistance().getValue()));
            checkChampionDistance(car);

        }
    }

    public void checkChampionDistance(Car car) {
        if (car.getDistance().faterThan(championDistance)) {
            this.championDistance = car.getDistance();
        }
    }

    public void filterChampions() {
        List<Car> championCarList = new ArrayList<>();

        for (Car car : this.carList) {
            if (car.getDistance().faterThanEqual(championDistance)) {
                championCarList.add(car);
            }
        }

        this.carList = championCarList;
    }

    @Override
    public String toString() {

        List<String> championCarNames = new ArrayList<>();

        for (Car car : this.carList) {
            championCarNames.add(car.getName());
        }

        return String.join(",", championCarNames);
    }

}
