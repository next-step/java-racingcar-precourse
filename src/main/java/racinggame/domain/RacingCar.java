package racinggame.domain;

public class RacingCar {
    private RacingCarName racingCarName;
    private int movesCount;

    public RacingCar(String racingCarName) {
        this.racingCarName = new RacingCarName(racingCarName);
        this.movesCount = 0;
    }

    public String getRacingCarName() {
        return racingCarName.getRacingCarName();
    }

    public int getMovesCount() {
        return movesCount;
    }

    public void move() {
        this.movesCount += 1;
    }

    public void stop() {
        this.movesCount += 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(racingCarName.getRacingCarName());
        result.append(" : ");
        for (int i = 0; i < this.movesCount; i++) {
            result.append("-");
        }
        return result.toString();
    }
}
