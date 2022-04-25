package racingcar.domain.car;

public class CarName {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private final static String DELIMITER = ",";
    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String names) {
        namesValidator(names);
    }

    private void namesValidator(String input) {
        String[] names = input.split(DELIMITER);
        delimiterValidator(names);
    }

    private void delimiterValidator(String[] names) {
        for (String name : names) {
            nameValidator(name);
        }
    }

    private void nameValidator(String name) {
        boolean isValidatedName = (name.length() <= MAX_NAME_LENGTH) && (name.length() >= MIN_NAME_LENGTH);
        if (!isValidatedName)
            throw new IllegalArgumentException();
    }

    public String getName() {
        return name;
    }

    public static String[] splitNames(String names) {
        return names.split(",");
    }
}
