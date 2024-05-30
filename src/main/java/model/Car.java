package model;

public class Car {

    private final String name;
    private Integer step;

    public Car(String name) {
        this.name = name;
        step = 0;
    }

    public void moveOrNot(int number) {
        if (canMove(number)) {
            step++;
        }
    }

    private boolean canMove(int number) {
        return number >= 4;
    }

    public String getName() {
        return name;
    }

    public Integer getStep() {
        return step;
    }
}
