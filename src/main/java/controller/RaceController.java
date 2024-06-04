package controller;

import java.util.Arrays;
import java.util.stream.Collectors;
import service.CarServiceInterface;
import service.RaceServiceInterface;
import view.RaceViewInterface;

public class RaceController implements RaceControllerInterface {

    private RaceServiceInterface race;
    private RaceViewInterface view;

    @Override
    public void init() {

    }

    @Override
    public void play() {

    }

    @Override
    public void end() {

    }

    @Override
    public void addCars(String[] cars) {
        try {
            race.addCars(cars);
        } catch (IllegalArgumentException e) {
            view.printCarsErrorMessage(e.getMessage());
            view.userCarsInput();
        }
    }

    @Override
    public void setRound(int numberOfRound) {

    }
}
