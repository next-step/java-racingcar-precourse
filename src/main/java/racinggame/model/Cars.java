package racinggame.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList = new ArrayList<Car>();

    public Cars(String carNames) {
        String[] carNameArr = carNames.split(",");
        for (String carName: carNameArr) {
            carList.add(new Car(carName));
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int countCars() {
        return carList.size();
    }

}
