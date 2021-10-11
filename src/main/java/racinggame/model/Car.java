package racinggame.model;

public class Car {
    private static final String PLAYER_LOCATION_SEPERATOR = " : ";
    private static final String LOCATION_INDICATOR = "-";

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

    public String getPlayerName(){
        return this.playerName;
    }

    public CarLocation getLocation() {
        return this.location;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(this.playerName + PLAYER_LOCATION_SEPERATOR);
        for (int i = 0; i < this.location.get(); i++) {
            builder.append(LOCATION_INDICATOR);
        }

        return builder.toString();
    }
}
