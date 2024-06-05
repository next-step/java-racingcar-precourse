package service;

import java.util.ArrayList;

public interface RaceServiceInterface {

    public int getNumberOfCars();

    public int getNumberOfRounds();

    public ArrayList<CarServiceInterface> getCars();

    public String getWinners();

    public void addCars(String[] cars);

    public void setNumberOfRounds(String rounds);
}
