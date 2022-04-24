package racingcar.model;

public class CarMoveRule {
    private final int moveNum;
    private final int stopNum;
    private final int moveMinCondition;

    public CarMoveRule(int moveNum, int stopNum, int moveMinCondition) {
        this.moveNum = moveNum;
        this.stopNum = stopNum;
        this.moveMinCondition = moveMinCondition;
    }

    public int getMoveNum() {
        return moveNum;
    }

    public int getStopNum() {
        return stopNum;
    }

    public int getMoveMinCondition() {
        return moveMinCondition;
    }
}
