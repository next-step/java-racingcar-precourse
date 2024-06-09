package app.model;

public class RacingCar {
    private String name;
    private int location;

    public RacingCar(String name) {
        this.name = name;
        this.location = 0;
    }

    public void printCurLocation() {
        System.out.println(this.name + " : " + "-".repeat(location));
    }

}
