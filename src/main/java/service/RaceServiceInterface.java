package service;

import java.util.List;
import model.CarModelInterface;

public interface RaceServiceInterface {

    public int getNumberOfCars();

    public List<CarModelInterface> getCars();

    public List<CarModelInterface> getWinners();

    public void addCars(String[] cars);

    public void prepareRace(String rounds);

    public void startRace();
}
