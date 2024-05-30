package model;

public class Car {

    private final String name;
    private Integer step;

    public Car(String name) {
        this.name = name;
        step = 0;
    }
    
    public void forward() {
        step++;
    }

    public String getName() {
        return name;
    }

    public Integer getStep() {
        return step;
    }
}
