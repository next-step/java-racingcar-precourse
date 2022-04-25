package racingcar.domain.result;

import racingcar.domain.car.CarName;

public class Result {

    private WinNames winNames;

    public Result(WinNames winNames) {
        this.winNames = winNames;
    }

    public void addWinner(CarName carName) {
        winNames.getWinNames().add(carName.getName());
    }

    public String getWinners() {
        return winNames.toString();
    }
}
