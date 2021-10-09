package racinggame.domain;

public class InputCarsName {

    private String name;

    public InputCarsName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static InputCarsName of(String name) {
        return new InputCarsName(name);
    }
}
