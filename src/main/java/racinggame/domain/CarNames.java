package racinggame.domain;

import racinggame.CarNameValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarNames {
    private static final String SPLIT_DELIMITER = ",";
    private final List<String> names;

    public CarNames(String carNamesText) {
        this.names = parse(carNamesText);
    }

    public List<String> getNames() {
        return names;
    }

    public static List<String> parse(String text) {
        List<String> carNames = split(text);
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 최소 1개 이상의 자동차 이름이 필요합니다");
        }
        return carNames;
    }

    private static List<String> split(String text) {
        if (text == null) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        for (String value : text.split(SPLIT_DELIMITER)) {
            addTrimmedValue(result, value);
        }
        return result;
    }

    private static void addTrimmedValue(List<String> result, String value) {
        String trimmedValue = value.trim();
        if (!trimmedValue.isEmpty()) {
            CarNameValidator.validate(trimmedValue);
            result.add(trimmedValue);
        }
    }
}
