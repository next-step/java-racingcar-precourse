package racingcar.car;

public class CarName {

    private static final int LIMIT = 5;

    private String name;

    public CarName(String name) {
        if(validate(name)) {
            this.name = name;
            return;
        }
        throw new IllegalArgumentException(
                "[ERROR] The car name is limited to 5 characters or less. but your input: " + name
        );
    }

    private boolean validate(String name) {
        if(name.length() <= LIMIT) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
