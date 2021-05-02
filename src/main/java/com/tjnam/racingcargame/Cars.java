package com.tjnam.racingcargame;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<Car>;

    public Cars(List<CarName> carNames){
        for(CarName name : carNames) {
            cars.add(new Car(name));
        }
    }
}
