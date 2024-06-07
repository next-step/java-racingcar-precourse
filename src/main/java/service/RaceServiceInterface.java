package service;

import java.util.List;

public interface RaceServiceInterface {

    public int getNumberOfCars();

    public List<CarServiceInterface> getCars();

    public List<CarServiceInterface> getWinners();

    public void addCars(String[] cars);

    public void setNumberOfRounds(String rounds);
}
