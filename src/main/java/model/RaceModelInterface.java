package model;

import java.util.ArrayList;
import service.CarServiceInterface;

public interface RaceModelInterface {
    public int getNumberOfCars();
    public int getNumberOfRounds();
    public ArrayList<CarServiceInterface> getCars();
    public void addCar(CarServiceInterface carServiceInterface);
}
