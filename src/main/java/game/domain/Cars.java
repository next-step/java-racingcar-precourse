package game.domain;

import java.util.List;

public class Cars {

    private List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void move() {
        carList.forEach(Car::move);
    }

}
