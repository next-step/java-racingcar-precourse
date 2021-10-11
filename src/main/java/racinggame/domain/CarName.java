package racinggame.domain;

public class CarName {
    private final String name;
    private final boolean isValid;

    public CarName(String name) {
        this.name = name;
        isValid = validName(name);
    }

    public boolean getIsValid() {
        return isValid;
    }

    private boolean validName(String name) {
        if (name == null) {
            return false;
        }
        return name.length() >= 1 && name.length() <= 5;
    }
}
