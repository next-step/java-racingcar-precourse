package racingcar.model;

import racingcar.entity.CarEntity;

import java.util.ArrayList;

public class RacingCarList {

    private ArrayList<CarEntity> carList;

    public RacingCarList() {
        carList = new ArrayList<>();
    }

    public boolean addCar(CarEntity car) {
        carList.add(car);
        return true;
    }

    public int getCarCount() {
        return carList.size();
    }

    public CarEntity getCarEntity(int i) {
        if (i >= carList.size())
            return null;

        return carList.get(i);
    }

    public boolean clearCarList(){
        carList.clear();
        return true;
    }

}
