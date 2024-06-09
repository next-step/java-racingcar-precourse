package model;

import java.util.List;
import observer.Observer;
import service.CarServiceInterface;

public interface RaceModelInterface {

    int getNumberOfCars();

    void prepareRace(String rounds);

    List<CarServiceInterface> getCars();

    void addCars(String[] carsName);

    void startRace();
}
