package racingcar.utils;

import racingcar.constants.ErrorMessage;
import racingcar.model.Car;
import racingcar.model.CarName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarGeneratorUtils {

    private static final String REST = ",";

    private CarGeneratorUtils() {
        throw new ClassCastException();
    }

    public static List<Car> getCars(String name) {
        ValidationUtils.validObjectThrowIfNull(name, ErrorMessage.NAME_IS_REQUIRED);
        final String[] names = getUniqueNamesThrowIfDuplicate(name);
        final List<Car> cars = new ArrayList<>();

        for (String uniqueName : names) {
            CarName carName = new CarName(uniqueName);
            cars.add(new Car(carName));
        }

        return cars;
    }

    private static String[] getUniqueNamesThrowIfDuplicate(String name) {
        final String[] names = name.split(REST);
        final Set<String> uniqueNames = new HashSet<>();
        Collections.addAll(uniqueNames, names);
        ValidationUtils.validConditionThrowIfTrue(
                names.length != uniqueNames.size(), ErrorMessage.NAME_MUST_BE_UNIQUE);
        return names;
    }

}
