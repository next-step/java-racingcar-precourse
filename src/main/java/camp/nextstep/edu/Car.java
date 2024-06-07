package camp.nextstep.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Car {

    private final String name;

    private final List<String> racingResult;

    private final String symbol;

    public Car(String name) {
        this(name, "-");
    }

    public Car(String name, String symbol) {
        this.name = name;
        this.racingResult = new ArrayList<>();
        this.symbol = symbol;
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
            racingResult.add(symbol);
        }
    }

    public String racingProgressStatus() {
        return name + " : " + String.join("", racingResult);
    }

    public String racingProgressStatus(BiFunction<String, List<String>, String> formatter) {
        return formatter.apply(name, racingResult);
    }

    public int recordPosition() {
        return racingResult.size();
    }
}
