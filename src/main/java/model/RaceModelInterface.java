package model;

import java.util.List;

public interface RaceModelInterface {

    int getNumberOfCars();

    int getNumberOfRounds();

    void prepareRace(String rounds);

    List<CarModelInterface> getCars();

    void addCars(String[] carsName);

    void startRace();
}
