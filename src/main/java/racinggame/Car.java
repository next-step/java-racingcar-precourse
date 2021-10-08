package racinggame;

import racinggame.utils.MoveUtils;

public class Car {
    private String carNm;
    private int distance = 0;

    public Car(String carNm) {
        this.carNm = carNm;
    }

    public int getDistance() {
        return distance;
    }

    public void play(int n) {
        if (MoveUtils.isGo(n)) {
            distance++;
        }
    }

    public String getCarNm() {
        return this.carNm;
    }
}
