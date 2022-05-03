package racingcar.domain;

import java.util.LinkedList;
import java.util.List;

public class RacingCars {
    private List<RacingCar> racingCars = new LinkedList<>();

    public RacingCars(){
    }

    public void addCar(RacingCar racingCar){
        racingCars.add(racingCar);
    }

    public List<RacingCar> returnRacingCars(){
        return racingCars;
    }

    public RacingCar returnRacingCarAtIndex(int index){
        return racingCars.get(index);
    }

    public int size(){
        return racingCars.size();
    }
}
