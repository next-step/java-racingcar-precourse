package dto;

import java.util.List;

public class CarName {
    private final List<String> nameList;

    public CarName(String carNames) {
        validateRawNames(carNames);
        String[] names = carNames.split(",");
        for (String name : names) {
            validateName(name);
        }
        this.nameList = List.of(names);
    }

    public List<String> getNameList() {
        return nameList;
    }

    private void validateRawNames(String rawNames) {
        if (rawNames.isEmpty() || rawNames.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 빈 문자열일 수 없습니다.");
        }
    }

    private void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 빈 문자열일 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}
