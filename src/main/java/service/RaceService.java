package service;

import java.util.ArrayList;
import model.RaceModelInterface;
import observer.Observer;
import observer.Subject;

public class RaceService implements Subject, RaceServiceInterface {

    private RaceModelInterface race;

    @Override
    public int getNumberOfCars() {
        return 0;
    }

    @Override
    public int getNumberOfRounds() {
        return 0;
    }

    @Override
    public ArrayList<CarServiceInterface> getCars() {
        return null;
    }

    @Override
    public void addCar(CarServiceInterface carServiceInterface) {

    }

    public boolean roundValidation() {
        return true;
    }

    @Override
    public void addObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }
}
