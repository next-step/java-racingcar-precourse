package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String DELIMITER = ",";
    private List<Car> cars;

    public Cars(String names) {
        List<Car> tempCars = new ArrayList<>();
        for (String name : names.split(DELIMITER)) {
            tempCars.add(new Car(name));
        }

        this.cars = tempCars;
    }

    public void tryMove() {
        cars.forEach(car -> {
            car.tryMovePosition();
            System.out.println(car.carStatus());
        });
        System.out.println();
    }

    public RaceResult getRaceResult() {
        RaceResult raceResult = new RaceResult();
        int furthestPositionValue = getFurthestPositionValue();

        cars.forEach(car -> {
            if (car.getPositionValue() == furthestPositionValue) {
                raceResult.addWinnerCar(car.getCarNameValue());
            }
        });

        return raceResult;
    }

    public int getFurthestPositionValue() {
        cars.sort((a, b) -> a.getPositionValue() > b.getPositionValue() ? -1 : 1);

        return cars.get(0).getPositionValue();
    }
}
