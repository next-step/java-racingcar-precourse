package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Victors {

    private final List<String> victors = new ArrayList<>();

    void add(String name) {
        victors.add(name);
    }

    @Override
    public String toString() {
        return String.join(",", victors);
    }
}