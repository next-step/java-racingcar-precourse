package racingcar.car;

import racingcar.common.Input;
import racingcar.game.Printer;

import java.util.*;

public class CarNames {

    private final Set<CarName> names;

    public final static String SPLIT_REGEX = ",";

    private CarNames() {
        List<CarName> listOfNames = initNames();

        validateNames(listOfNames);

        this.names = new LinkedHashSet<>(listOfNames);
    }

    private CarNames(Set<CarName> names) {
        this.names = names;
    }

    public static CarNames fromConsole() {
        return new CarNames();
    }

    public static CarNames of(Set<CarName> names) {
        return new CarNames(names);
    }

    public String toStringWithJoinDelimiter(String delimiter) {
        List<String> toStringCollection = new ArrayList<>();

        for (CarName name : names()) {
            toStringCollection.add(name.toString());
        }

        return String.join(delimiter, toStringCollection);
    }

    public Set<CarName> names() {
        return this.names;
    }

    private List<CarName> initNames() {
        List<CarName> names = new ArrayList<>();

        for (String name
                : Input.fromConsole().splitToString(SPLIT_REGEX)) {
            names.add(CarName.of(name));
        }

        return names;
    }

    private void validateNames(List<CarName> listOfNames) {
        Set<CarName> toSet = new HashSet<>(listOfNames);

        if (listOfNames.size() != toSet.size()) {
            Printer.duplicateOfCarName();
            throw new IllegalArgumentException();
        }
    }

}
