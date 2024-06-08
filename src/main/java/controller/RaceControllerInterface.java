package controller;

public interface RaceControllerInterface {

    public void init();

    public void play();

    public void end();

    public void addCars(String[] cars);

    public void setRound(String numberOfRound);
}
