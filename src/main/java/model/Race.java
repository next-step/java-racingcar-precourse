package model;

import java.util.ArrayList;
import java.util.List;
import observer.Observer;
import observer.SubjectModel;
import service.CarServiceInterface;

public class Race implements SubjectModel, RaceModelInterface {

    private int numberOfRounds;
    private List<CarServiceInterface> cars;
    private List<Observer> observers;

    public Race() {
        this.numberOfRounds = 0;
        cars = null;
        observers = null;
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
