package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int forwardCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public void depart() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) forwardCount += 1;
    }

    public void printCar() {
        StringBuilder scoreLine = new StringBuilder();
        for (int i = 0; i < forwardCount; i++) {
            scoreLine.append("-");
        }
        System.out.println(name + " : " + scoreLine);
    }

}
