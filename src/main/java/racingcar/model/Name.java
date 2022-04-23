package racingcar.model;

public class Name {
    private static final int LENGTH = 5;

    private String name;

    public Name(String name) {
        checkNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void checkNameLength(String name) {
        if (name.length() > LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
