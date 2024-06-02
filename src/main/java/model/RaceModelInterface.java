package model;

import java.util.ArrayList;
import service.CarServiceInterface;

public interface RaceModelInterface {
    public int getNumberOfCars();
    public int getNumberOfRounds();
    public void setNumberOfRounds();
    public ArrayList<CarServiceInterface> getCars();
}
