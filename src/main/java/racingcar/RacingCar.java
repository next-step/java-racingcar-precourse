package racingcar;

public class RacingCar {
    private static final int INIT_GAME_POSITION_NUM = 0;
    private String name;
    private int gamePosition;

    public RacingCar(String name) {
        this(name, INIT_GAME_POSITION_NUM);
    }

    public RacingCar(String name, int gamePosition) {
        this.name = name;
        this.gamePosition = gamePosition;
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

    public void move(int randomValue) {
        if (randomValue >= RacingCarConstants.MIN_CAR_MOVE_CONDITION) {
            gamePosition++;
        }
    }
}
