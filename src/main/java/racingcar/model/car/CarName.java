package racingcar.model.car;

public class CarName {

    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름의 길이는 1~5자만 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }

}
