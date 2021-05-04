package domain.name;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CarNames {
    public static final String NAME_SPLITTER = ",";

    private List<CarName> names = new ArrayList<>();

    public CarNames(String names) {
        String[] splicedNames = names.split(NAME_SPLITTER);

        for (String name : splicedNames) {
            this.names.add(new CarName(name));
        }
    }

    public List<CarName> getNames() {
        return Collections.unmodifiableList(names);
    }

    @Override
    public boolean equals(Object dest) {
        if (this == dest) {
            return true;
        }
        if (dest == null || getClass() != dest.getClass()) {
            return false;
        }

        CarNames carNames = (CarNames) dest;
        return names.equals(carNames.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }
}
