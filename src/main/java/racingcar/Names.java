package racingcar;

import java.util.ArrayList;
import java.util.List;

import static racingcar.NameUtils.mapToList;

public class Names {
    private final List<Name> names;

    public Names(List<Name> names) {
        this.names = new ArrayList<>(names);
    }

    public Names(String strNames) {
        this.names = mapToList(strNames);
    }

    public List<Name> getNames() {
        return names;
    }
}
