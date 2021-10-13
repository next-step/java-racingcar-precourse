package racinggame.controller;

import racinggame.model.Car;
import racinggame.model.GameHost;

import java.util.ArrayList;

public class RacingController {

    public RacingController() {

        ArrayList<Car> carList = new ArrayList<>();

        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Car honux = new Car("honux");

        carList.add(pobi);
        carList.add(crong);
        carList.add(honux);

        GameHost gameHost = new GameHost(carList, 5);

    }


}
