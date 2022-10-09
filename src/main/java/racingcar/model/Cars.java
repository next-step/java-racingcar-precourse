package racingcar.model;

import racingcar.utils.InputString;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    List<Car> carsList;
    String inputCars;
    public Cars(InputString strInputCars) {
        this.inputCars = strInputCars.getStrValue();
        carsList = new ArrayList<>();
    }

    public List<Car> splitCars(Cars cars) {
        String[] splitCar = cars.inputCars.split(",");

        if(splitCar.length<2){
            throw new IllegalArgumentException("최소 2대 이상 입력해야 합니다.");
        }

        this.carsList = cars.carsList;
        for (String carName : splitCar) {
            Car car = new Car(new InputString(carName));
            carsList.add(car);
        }

        return carsList;
    }
}
