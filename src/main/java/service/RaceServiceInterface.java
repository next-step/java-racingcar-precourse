package service;

import java.util.List;
import model.CarModelInterface;

public interface RaceServiceInterface {

    int getNumberOfCars();

    List<CarModelInterface> getCars();

    List<CarModelInterface> getWinners();

    void addCars(String[] cars);

    void prepareRace(String rounds);

    void startRace();
}
