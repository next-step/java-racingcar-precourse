package racingcar.model.car;

public class CarName {
    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateIfNull(name);
        validateIfLength(name);
    }

    private void validateIfNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validateIfLength(String name) {
        String nameTrim = name.trim();
        if (nameTrim.length() < CarConfig.MIN_CAR_NAME_LENGTH || nameTrim.length() > CarConfig.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }
}
