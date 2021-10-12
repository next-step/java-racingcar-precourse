package racinggame.game.model.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(List<CarName> carNames) {
        this.carList = new ArrayList<>();
        for (CarName carName : carNames) {
            Car car = new Car(carName);
            this.carList.add(car);
        }
    }


    public void runRace() {
        for (Car car : this.carList) {
            car.runRace();
        }
    }

    public List<Car> getCarList() {
        return this.carList;
    }

}
