package model;

import java.util.List;

public class Race {
    private List<Car> cars;
    private int raceCount;

    public Race(List<Car> cars, int raceCount) {
        this.cars = cars;
        this.raceCount = raceCount;
    }

    public List<Car> getCars(){
        return cars;
    }

    public int getRaceCount(){
        return raceCount;
    }
}
