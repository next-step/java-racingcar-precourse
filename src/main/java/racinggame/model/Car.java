package racinggame.model;

public class Car {
    private String playerName;
    private CarLocation location;

    public Car(String playerName, int integerLocation) {
        this.playerName = playerName;
        this.location = new CarLocation(integerLocation);
    }

    public CarLocation forward() {
        this.location.increase();

        return this.location;
    }

    public CarLocation getLocation() {
        return this.location;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(this.playerName + ":");
        for (int i = 0; i < this.location.get(); i++) {
            builder.append("-");
        }

        return builder.toString();
    }
}
