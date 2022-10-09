package racingcar.model.cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarsValidator {
    private static final CarNamesAnalyzer ANALYZER = CarNamesAnalyzer.getInstance();

    public static void assertValid(String names) {
        CarsValidator.assertValidNamesLength(names);
        CarsValidator.assertValidNamesUnique(names);
    }

    private static void assertValidNamesLength(String names) {
        if (!CarsValidator.isValidNamesLength(names)) {
            throw new IllegalArgumentException();
        }
    }

    private static void assertValidNamesUnique(String names) {
        if (!CarsValidator.isValidNamesUnique(names)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isValidNamesUnique(String names) {
        String[] namesArray = CarsValidator.ANALYZER.getNamesArray(names);
        Set<String> set = new HashSet<>(Arrays.asList(namesArray));
        return namesArray.length == set.size();
    }

    private static boolean isValidNamesLength(String names) {
        List<Boolean> isValidNames = new ArrayList<>();
        for (String name : CarsValidator.ANALYZER.getNamesArray(names)) {
            isValidNames.add(CarsValidator.isValidNameLength(name));
        }
        return !isValidNames.contains(false);
    }

    private static Boolean isValidNameLength(String name) {
        return name.length() >= CarsValidator.ANALYZER.getMinLength()
                && name.length() <= CarsValidator.ANALYZER.getMaxLength();
    }
}
