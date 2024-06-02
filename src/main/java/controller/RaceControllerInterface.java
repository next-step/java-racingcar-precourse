package controller;

import service.CarServiceInterface;

public interface RaceControllerInterface {
    public void init();
    public void play();
    public void end();
    public void addCar(CarServiceInterface carServiceInterface);
    public void setRound(int numberOfRound);
}
