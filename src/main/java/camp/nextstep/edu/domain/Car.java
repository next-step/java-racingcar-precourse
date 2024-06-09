package camp.nextstep.edu.domain;

public class Car {

    private String name;
    private int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void moveForward() {
        if (canMoveForward()) {
            location += 1;
        }
    }

    public String currentStateMessage() {
        String state = "-".repeat(location);
        return name + " : " + state;
    }

    private boolean canMoveForward() {
        return (int) (Math.random() * 10) >= 4;
    }
}
