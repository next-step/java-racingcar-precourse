package racinggame.model;

public class Car {
    private String name;
    private CarLocation location;

    public Car(String name, int integerLocation){
        this.name = name;
        this.location = new CarLocation(integerLocation);
    }

    public CarLocation forward() {
        this.location.increase();

        return this.location;
    }

    public CarLocation getLocation() {
        return this.location;
    }
}
