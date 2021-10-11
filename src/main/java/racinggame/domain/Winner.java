package racinggame.domain;

public class Winner {
    private CarName name;

    public Winner(CarName name) {
        this.name = name;
    }

    public String getName() {
        return name.getName();
    }
}
