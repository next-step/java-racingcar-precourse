package racingcar.game;

import racingcar.domain.CarList;
import racingcar.domain.Referee;
import racingcar.game.status.Status;
import racingcar.view.status.EnterCarNameList;

public class GameContext {
    Status status = new EnterCarNameList();
    Referee referee;
    private String carNameList;
    private CarList carList;
    private String retryReadLine;
    private int retryCount;
    private int stepCount = 0;

    public Status next() {
        return (status = status.next(this));
    }

    public String getCarNameList() {
        return carNameList;
    }

    public void setCarNameList(String carNameList) {
        this.carNameList = carNameList;
    }

    public CarList getCarList() {
        return carList;
    }

    public void setCarList(CarList carList) {
        this.carList = carList;
    }

    public String getRetryReadLine() {
        return retryReadLine;
    }

    public void setRetryReadLine(String retryReadLine) {
        this.retryReadLine = retryReadLine;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public int getStepCount() {
        return stepCount;
    }

    public void increaseStep() {
        stepCount++;
    }

    public CarList judge(CarList carList) {
        referee = new Referee(carList);
        return referee.getWinnerList();
    }
}
