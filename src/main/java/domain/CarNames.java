package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarNames {
    private static final String NAME_SPLITTER = ",";

    private List<CarName> names;

    public CarNames(String names) {
        String[] splicedNames = names.split(NAME_SPLITTER);

        this.names = new ArrayList<>();
        for(String name : splicedNames) {
            this.names.add(new CarName(name));
        }
    }

    public List<CarName> getNames() {
        return new ArrayList<>(names);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarNames carNames = (CarNames) o;
        return names.equals(carNames.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }
}
