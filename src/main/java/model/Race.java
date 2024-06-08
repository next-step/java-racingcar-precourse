package model;

import java.util.ArrayList;
import java.util.List;
import observer.Observer;
import service.CarServiceInterface;

// model과 service를 분리해서 model은 getter, setter, 변수만 갖도록 함.
public class Race implements RaceModelInterface {

    private int numberOfRounds;
    private List<CarServiceInterface> cars;
    private List<Observer> observers;

    public Race() {
        this.numberOfRounds = 0;
        cars = new ArrayList<>();
        observers = new ArrayList<>();
    }

    @Override
    public int getNumberOfCars() {
        return cars.size();
    }

    @Override
    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    @Override
    public List<CarServiceInterface> getCars() {
        return cars;
    }

    @Override
    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    @Override
    public List<Observer> getObservers() {
        return observers;
    }
}
