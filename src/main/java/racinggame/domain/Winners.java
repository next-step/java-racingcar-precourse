package racinggame.domain;

import java.util.ArrayList;

public class Winners {
    private ArrayList<Car> winners;

    public Winners() {
        this.winners = new ArrayList<>();
    }

    public ArrayList<Car> getWinners() {
        return winners;
    }

    public void addWinners(Car car, MaxGoCount maxGoCount) {
        if (car.getGoCount().equals(maxGoCount.getMaxGoCount())) {
            winners.add(car);
        }
    }
}
