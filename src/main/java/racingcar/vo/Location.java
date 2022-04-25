package racingcar.vo;

public class Location {
    private int location;

    public Location(int location) {
        this.location = location;
    }

    public int getLocation() {
        return this.location;
    }

    public void move(int offset) {
        location += offset;
    }

    public boolean isWinningLocation(int winningLocation) {
        return location == winningLocation;
    }
}
