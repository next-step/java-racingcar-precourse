package racingcar.vo;

import java.util.List;

public class Name {
    private String name;

    public Name() {

    }

    public Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSingleName(String name) {
        this.name = name;
    }

    public void setMultipleName(String name) {
        this.name += ", " + name;
    }

    public String setMultipleName(List<Car> cars) {
        String winners = null;
        return winners;
    }
}