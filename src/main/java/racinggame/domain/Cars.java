package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(String carsStr) {
        carList = new ArrayList<>();
        String[] names = carsStr.split(",");
        for (String name : names) {
            carList.add(new Car(name));
        }
    }

    public int getSize() {
        return carList.size();
    }
}
