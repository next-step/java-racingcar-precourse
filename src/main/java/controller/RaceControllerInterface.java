package controller;

import service.RaceServiceInterface;

public interface RaceControllerInterface {

    public void init();

    public void play();

    public void end();

    public void addCars(RaceServiceInterface raceServiceInterface);

    public void setRound(int numberOfRound);
}
