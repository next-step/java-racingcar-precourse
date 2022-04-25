package racingcar.model;

import racingcar.constant.Symbol;

public class Distance {
    private StringBuilder distance;

    public Distance() {
        this.distance = new StringBuilder();
    }

    public void increaseDistance() {
        this.distance.append(Symbol.HYPHEN.getValue());
    }

    public String getPosition() {
        return distance.toString();
    }

    public int getDistence() {
        return distance.length();
    }

}
