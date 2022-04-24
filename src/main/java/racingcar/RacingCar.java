package racingcar;

public class RacingCar {
    private String name;
    private int gamePosition;

    public RacingCar(String name) {
        this.name = name;
        gamePosition = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGamePosition() {
        return gamePosition;
    }

    public void setGamePosition(int gamePosition) {
        this.gamePosition = gamePosition;
    }
}
