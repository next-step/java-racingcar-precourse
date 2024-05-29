package model;

public class RandomDriveCar implements Car {

    private final String name;
    private String state;

    public RandomDriveCar(String name) {
        this.name = name;
        this.state = "";
    }

    @Override
    public String drive() {
        return "";
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }
}
