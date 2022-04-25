package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final int MIN_RANGE = 0;
    private final int MAX_RANGE = 9;
    private final int FORWARD_VALUE = 4;
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    public void forward() {
        int value = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
        if(value >= FORWARD_VALUE) {
            distance++;
        }
    }

    public void printResult() {
        System.out.println(this.name + " : " + printDistance());
    }

    private String printDistance() {
        String distance = "";
        for(int i=0; i<this.distance; i++) {
            distance += "-";
        }
        return distance;
    }
}
