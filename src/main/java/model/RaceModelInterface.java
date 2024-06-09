package model;

import java.util.List;

public interface RaceModelInterface {

    int getNumberOfCars();

    void prepareRace(String rounds);

    List<CarModelInterface> getCars();

    void addCars(String[] carsName);

    void startRace();
}
