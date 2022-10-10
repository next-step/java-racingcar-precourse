package racingcar;

public class RacingCar {
    private String racingCarName;
    private int racingCarPosition;


    public RacingCar(String racingCarName, int racingCarPosition) {
        this.racingCarName = racingCarName;
        this.racingCarPosition = racingCarPosition;
    }

    public String getRacingCarName() {
        return racingCarName;
    }

    public int getRacingCarPosition() {
        return racingCarPosition;
    }

    public void checkCarAction(RacingCarAction action) {
        if(action.isGo()) this.racingCarPosition += 1;
    }
}
