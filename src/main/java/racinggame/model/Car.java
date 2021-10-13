package racinggame.model;

import racinggame.vo.PlayerName;

public class Car {
    private static final String PLAYER_LOCATION_SEPERATOR = " : ";
    private static final String LOCATION_INDICATOR = "-";

    private PlayerName playerName;
    private CarLocation location;

    public Car(PlayerName playerName, CarLocation location) {
        this.playerName = playerName;
        this.location = location;
    }

    public CarLocation forward() {
        this.location.increase();

        return this.location;
    }

    public PlayerName getPlayerName(){
        return this.playerName;
    }

    public CarLocation getLocation() {
        return this.location;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(this.playerName.get() + PLAYER_LOCATION_SEPERATOR);
        for (int i = 0; i < this.location.get(); i++) {
            builder.append(LOCATION_INDICATOR);
        }

        return builder.toString();
    }
}
