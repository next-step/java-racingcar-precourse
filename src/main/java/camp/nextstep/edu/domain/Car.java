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

    public void moveLocation() {
        if (canMoveForward()) {
            location += 1;
        }
    }

    private boolean canMoveForward() {
        return (int) (Math.random() * 10) >= 4;
    }
}
