package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.stream.IntStream;

public class Car {

    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void movePosition() {
        if(Randoms.pickNumberInRange(0, 9) >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getCurrentResult() {
        StringBuilder result = new StringBuilder();
        result.append(name).append(" : ");

        for(int i=0; i<position; i++) {
            result.append("-");
        }

        return result.append("\n").toString();
    }


}
