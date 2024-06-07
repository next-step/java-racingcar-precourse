package model;

import java.util.List;
import service.CarServiceInterface;

public interface RaceModelInterface {

    public int getNumberOfCars();

    public int getNumberOfRounds();

    public void setNumberOfRounds(int numberOfRounds);

    public List<CarServiceInterface> getCars();
}
