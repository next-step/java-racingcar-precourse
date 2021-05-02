package dto;

public class CarRequest {
    private final String carName;
    private final int moveJudgementNumber;

    public CarRequest(String carName, int moveJudgementNumber) {
        this.carName = carName;
        this.moveJudgementNumber = moveJudgementNumber;
    }

    public String getCarName() {
        return carName;
    }

    public int getMoveJudgementNumber() {
        return moveJudgementNumber;
    }
}
