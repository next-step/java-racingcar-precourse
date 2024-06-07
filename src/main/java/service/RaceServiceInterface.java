package service;

import java.util.ArrayList;
import java.util.List;

public interface RaceServiceInterface {

    public int getNumberOfCars();

    public int getNumberOfRounds();

    public ArrayList<CarServiceInterface> getCars();

    public List<CarServiceInterface> getWinners();

    public void addCars(String[] cars);

    public void setNumberOfRounds(String rounds);
}
