package racinggame.domain;

public class Location {

    public static final int START_LOCATION = 0;

    private int location;

    public Location(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public void moveLocation() {
        location++;
    }
}
