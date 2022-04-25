package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarsGenerator {
    public static Cars create(Names names){
        List<Car> cars = new ArrayList<>();
        for (Name name : names.getNames()){
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }
}
