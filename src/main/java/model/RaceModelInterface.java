package model;

import java.util.List;
import observer.Observer;
import service.CarServiceInterface;

public interface RaceModelInterface {

    int getNumberOfCars();

    int getNumberOfRounds();

    void prepareRace(String rounds);

    List<CarServiceInterface> getCars();

    List<Observer> getObservers();

    void addCars(String[] carsName);
}
