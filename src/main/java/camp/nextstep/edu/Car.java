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

}
