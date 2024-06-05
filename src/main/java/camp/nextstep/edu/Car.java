package camp.nextstep.edu;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String name;

    private List<String> racingResult;

    public Car(String name) {
        this.name = name;
        this.racingResult = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private boolean canIRace() {
        int num = (int) (Math.random() * 10);
        return num >= 4;
    }

    public void race() {
        if (canIRace()) {
            racingResult.add("-");
        }
    }
    public String racingProgressStatus() {
        return name + " : " + String.join("", racingResult);
    }
}
