package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;
    private static final String nameDelimiter = ",";

    public Cars(String inputNames) {
        cars = new ArrayList<>();
        String[] carsName = splitInput(inputNames);
        for(String carName : carsName){
            cars.add(new Car(carName));
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    private String[] splitInput(String input){
        return input.split(nameDelimiter);
    }
}
