package racingcar.model;

import java.util.ArrayList;

public class Referee {
    private final Cars winnerCars;
    private int winnerFigure;

    public Referee() {
        this.winnerCars = new Cars();
        this.winnerFigure = -1;
    }

    public ArrayList<String> getWinner(Cars cars) {
        for (Car car : cars.getCars()) {
            winnerFigure = judgment(car.getLocation().length());
        }
        for (Car car : cars.getCars()) {
            addWinnerList(car);
        }

        return getWinnerNames();
    }

    private int judgment(int figure) {
        if (figure >= winnerFigure) {
            winnerFigure = figure;
        }

        return winnerFigure;
    }

    private void addWinnerList(Car car) {
        if (car.getLocation().length() == winnerFigure) {
            winnerCars.add(car);
        }
    }

    private ArrayList<String> getWinnerNames() {
        ArrayList<String> winnerNames = new ArrayList<>();
        for (Car car : winnerCars.getCars()) {
            winnerNames.add(car.getName());
        }

        return winnerNames;
    }
}
