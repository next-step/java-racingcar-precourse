package service;

import java.util.ArrayList;

public interface RaceServiceInterface {
    public int getNumberOfCars();
    public int getNumberOfRounds();
    public void setNumberOfRounds();
    public ArrayList<CarServiceInterface> getCars();
}
