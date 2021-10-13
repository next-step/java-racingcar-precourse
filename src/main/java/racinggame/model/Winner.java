package racinggame.model;

import racinggame.utils.GameRule;

public class Winner {
    CarGroup winnerGroup = new CarGroup();
    int distance = 0;

    public Winner(CarGroup group) {
        for (Car car : group.getCarGroup()) {
            setWinner(car);
        }
    }

    public String getWinnerNames() {
        StringBuilder winnerNames = new StringBuilder();

        for (Car car : winnerGroup.getCarGroup()) {
            winnerNames.append(car.getCarName());
            winnerNames.append(GameRule.SEPARATOR);
        }

        if (winnerNames.length() > 0) {
            winnerNames.setLength(winnerNames.length() - 1);
        }

        return winnerNames.toString();
    }

    private void setWinner(Car car) {
        int compared = Integer.compare(car.distance, this.distance);
        if (compared > 0) {
            winnerGroup.removeAll();
        }

        if (compared >= 0) {
            winnerGroup.appendCar(car);
            this.distance = car.distance;
        }
    }

}
