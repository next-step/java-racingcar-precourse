package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarNames {
    private static final String SPLIT_DELIMITER = ",";
    private final List<CarName> names;

    public CarNames(String carNamesText) {
        this.names = parse(carNamesText);
    }

    public List<CarName> getNames() {
        return names;
    }

    private static List<CarName> parse(String text) {
        List<String> carNames = split(text);
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 최소 1개 이상의 자동차 이름이 필요합니다");
        }
        return mapCarNames(carNames);
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
            result.add(trimmedValue);
        }
    }

    private static List<CarName> mapCarNames(List<String> carNames) {
        List<CarName> result = new ArrayList<>();
        for (String name : carNames) {
            result.add(new CarName(name));
        }
        return result;
    }
}
