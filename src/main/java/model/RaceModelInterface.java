package model;

import java.util.List;
import observer.Observer;
import service.CarServiceInterface;

public interface RaceModelInterface {

    public int getNumberOfCars();

    public int getNumberOfRounds();

    public void setNumberOfRounds(int numberOfRounds);

    public List<CarServiceInterface> getCars();

    public List<Observer> getObservers();
}
