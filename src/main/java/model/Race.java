package model;

import java.util.ArrayList;
import observer.Observer;
import observer.Subject;
import observer.SubjectModel;
import service.CarServiceInterface;

public class Race implements SubjectModel, RaceModelInterface {

    private final int numberOfRounds;
    private ArrayList<CarServiceInterface> cars;
    private ArrayList<Observer> observers;

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
    public ArrayList<CarServiceInterface> getCars() {
        return cars;
    }

    @Override
    public ArrayList<Observer> getObservers() {
        return observers;
    }
}
