package racinggame.model;

import java.util.ArrayList;

public class Winner {
    private ArrayList<String> winnerList;
    private long max;

    public Winner() {
        winnerList = new ArrayList<>();
        this.max = 0;
    }

    public ArrayList<String> getWinnerList() {
        return winnerList;
    }

    public void getWinner() {
        for (Car car : CarSet.getCarSetInstance().getCars()) {
            updateMax(car);
        }
    }

    private void updateMax(Car car) {
        if (car.getPosition() > max) {
            winnerList.clear();
            max = car.getPosition();
            winnerList.add(car.getName());
            return;
        }

        if (car.getPosition() == max) {
            winnerList.add(car.getName());
        }
    }
}
