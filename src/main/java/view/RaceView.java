package view;

import controller.RaceControllerInterface;
import observer.Observer;
import service.RaceServiceInterface;

public class RaceView implements Observer, RaceViewInterface {

    private RaceServiceInterface raceServiceInterface;
    private RaceControllerInterface raceControllerInterface;

    @Override
    public void update() {

    }

    @Override
    public void userCarsInput() {

    }

    @Override
    public void userRoundsInput() {

    }

    @Override
    public void printProgress() {

    }

    @Override
    public void printProcess() {

    }

    @Override
    public void printResult() {

    }
}
