package racingcar.model;

public class CarMoveRule {
    private final int moveNum;
    private final int stopNum;
    private final int moveMinCondition;
    private final String printMoveWord;

    public CarMoveRule(int moveNum, int stopNum, int moveMinCondition, String printMoveWord) {
        this.moveNum = moveNum;
        this.stopNum = stopNum;
        this.moveMinCondition = moveMinCondition;
        this.printMoveWord = printMoveWord;
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

    public String getPrintMoveWord() {
        return printMoveWord;
    }
}
