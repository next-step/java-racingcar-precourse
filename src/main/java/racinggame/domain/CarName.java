package racinggame.domain;

public class CarName {
    private final String name;

    public CarName(final String name) {
        carNameValidation(name);
        this.name = name;
    }

    public void carNameValidation(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }
}
