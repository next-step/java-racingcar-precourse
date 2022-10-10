package racingcar.domain;


public class RacingCar  {

    private int moveCnt = 0;
    private String carName;

    public RacingCar(String carName) {
        this.carName = carName;
    }

    public void racing(int randomNum, Move move) {
        if(move.moveChk(randomNum)) {
            moveCnt++;
        }
    }

    public String getName() {
        return carName;
    }

    public int moveCnt() {
        return moveCnt;
    }
}
