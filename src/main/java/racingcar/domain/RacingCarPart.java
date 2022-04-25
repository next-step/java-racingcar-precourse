package racingcar.domain;

import java.util.LinkedList;
import java.util.List;

public class RacingCarPart {
    private List<String> names = new LinkedList<>();

    public RacingCarPart() { }

    public void addName(String input) {
        names.add(input);
    }

    public List<String> getNames() {
        return names;
    }

    public int size() {
        return names.size();
    }
}
