package model;

import java.util.ArrayList;
import observer.Observer;
import observer.Subject;
import service.CarServiceInterface;
import service.RaceServiceInterface;

public class Race implements Subject, RaceServiceInterface {
    private final int numberOfRounds;
    private ArrayList<CarServiceInterface> cars;
    private ArrayList<Observer> observers;

    public Race() {
        this.numberOfRounds = 0;
        cars = null;
        observers = null;
    }

    public Race(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
        cars = new ArrayList<>();
        observers = new ArrayList<>();
    }

    @Override
    public int getNumberOfCars()  {
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
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) observer.update();
    }
}
