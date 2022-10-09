package racingcar.model.cars;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.cars.factory.CarFactory;
import racingcar.model.cars.factory.Title;

public class Cars {
    private final CarNamesAnalyzer carNamesAnalyzer;
    private final String carNames;

    private Cars(String carNames) {
        CarsValidator.assertValid(carNames);
        this.carNames = carNames;
        this.carNamesAnalyzer = CarNamesAnalyzer.getInstance();
    }

    public static Cars of(String carNames) {
        return new Cars(carNames);
    }

    public List<Car> get() {
        return this.createCarList();
    }

    private List<Car> createCarList() {
        List<Car> carList = new ArrayList<>();
        for (Title title : this.getTitles()) {
            carList.add(CarFactory.create(title));
        }
        return carList;
    }

    private List<Title> getTitles() {
        List<Title> titles = new ArrayList<>();

        for (String carName : carNamesAnalyzer.getNamesArray(carNames)) {
            titles.add(new Title(carName));
        }
        return titles;
    }
}
