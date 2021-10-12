package racinggame;

public class CarName {
    private final String name;

    public CarName(String name) {
        validateNameLen(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateNameLen(String name) {
        if (name == null || name.length() == 0) {
            throw new NullPointerException(ErrorMessage.printNotNullNameMessage());
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.printNotCorrectNameLengthMessage(name));
        }
    }
}
