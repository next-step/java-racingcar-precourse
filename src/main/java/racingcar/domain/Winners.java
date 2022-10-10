package racingcar.domain;

import java.util.List;

public class Winners {

    private final List<String> names;

    private Winners (List<String> names) {
        this.names = names;
    }

    public static Winners from(List<String> names) {
        return new Winners(names);
    }

    public List<String> getNames() {
        return this.names;
    }
}
