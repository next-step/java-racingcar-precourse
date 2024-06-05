package model;

import java.util.ArrayList;
import service.CarServiceInterface;

public interface RaceModelInterface {

    public int getNumberOfCars();

    public int getNumberOfRounds();

    public void setNumberOfRounds(String numberOfRounds);

    public ArrayList<CarServiceInterface> getCars();
}
