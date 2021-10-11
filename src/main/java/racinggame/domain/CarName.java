package racinggame.domain;

public class CarName {
    private String name;

    public CarName(String name) {
        registerName(name);
    }

    private void registerName(String name) {
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }
}
