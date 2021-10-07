package racinggame.domain;

import racinggame.error.ValidationFailureException;
import racinggame.type.Messages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CarNames {

    private static final String NAME_SEPARATOR = ",";

    private final List<CarName> names;

    private CarNames(List<CarName> names) {
        this.names = names;
    }

    public static CarNames from(String s) {
        throwNotIfCommaBetweenThem(s);
        List<String> names = toSeparatedNames(s);
        return new CarNames(mapToCarName(names));
    }

    private static List<CarName> mapToCarName(List<String> names) {
        List<CarName> carNames = new ArrayList<>(names.size());
        for (String name : names) {
            carNames.add(CarName.from(name));
        }
        return carNames;
    }

    private static List<String> toSeparatedNames(String names) {
        return Arrays.asList(names.split(NAME_SEPARATOR));
    }

    private static void throwNotIfCommaBetweenThem(String name) {
        throwIfEmptyTrimmedName(name);
        if (name.startsWith(NAME_SEPARATOR) || name.endsWith(NAME_SEPARATOR)) {
            throw new ValidationFailureException(Messages.ERROR_INVALID_CAR_NAME.getMessage());
        }
    }

    private static void throwIfEmptyTrimmedName(String name) {
        if (Objects.isNull(name) || name.trim().isEmpty()) {
            throw new ValidationFailureException(Messages.ERROR_INVALID_CAR_NAME.getMessage());
        }
    }

    public CarName get(int idx) {
        return this.names.get(idx);
    }

    public int size() {
        return this.names.size();
    }

}
