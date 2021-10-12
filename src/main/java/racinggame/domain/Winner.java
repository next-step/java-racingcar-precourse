package racinggame.domain;

public class Winner {
    private CarName name;

    public Winner(String name) {
        this.name = new CarName(name);
    }

    public String getName() {
        return name.getName();
    }
}
