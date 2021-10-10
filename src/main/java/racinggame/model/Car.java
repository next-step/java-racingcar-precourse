package racinggame.model;

public class Car {
    private String name;
    private int location;

    public Car(String name, int location){
        this.name = name;
        this.location = location;
    }

    public int forward() {
        this.location++;

        return this.location;
    }

    public int getLocation() {
        return this.location;
    }
}
