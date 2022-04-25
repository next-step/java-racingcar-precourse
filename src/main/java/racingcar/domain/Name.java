package racingcar.domain;

public class Name {

    String name;
    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 5;

    public Name(String name) {
        if (validationNameLength(name)) {
            this.name = name;
            return;
        }
        throw new IllegalArgumentException("[ERROR] Name Length");
    }

    public String getName() {
        return this.name;
    }

    private boolean validationNameLength(String name) {
        return (MIN_NAME_LENGTH <= name.length() && name.length() <= MAX_NAME_LENGTH);
    }

}
