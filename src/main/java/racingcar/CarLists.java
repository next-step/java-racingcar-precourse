package racingcar;

import java.util.List;

public class CarLists {

    private final List<Car> cars;

    public CarLists(List<Car> cars) {
        this.cars=cars;
    }

    public void moveCars(RacingCarView view) {
        for(int i=0;i<cars.size();i++) {
            cars.get(i).accel();
            view.printDistance(cars.get(i));
        }
        System.out.println();
    }
}
