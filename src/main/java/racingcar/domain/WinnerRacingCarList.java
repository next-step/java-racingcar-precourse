package racingcar.domain;

import java.util.List;

public class WinnerRacingCarList {

    private final List<RacingCar> winnerRacingCarList;

    public WinnerRacingCarList(List<RacingCar> winnerRacingCarList) {
        this.winnerRacingCarList = winnerRacingCarList;
    }

    public List<RacingCar> getWinnerRacingCarList() {
        return winnerRacingCarList;
    }

    public String winnerName() {
        StringBuilder printWinner = new StringBuilder();
        for (RacingCar winner : this.winnerRacingCarList) {
            printWinner.append(winner.getName()).append(",");
        }
        return printWinner.toString();
    }

    public static WinnerRacingCarList of(List<RacingCar> winnerRacingCarList) {
        return new WinnerRacingCarList(winnerRacingCarList);
    }

    public static WinnerRacingCarList testInstance(List<RacingCar> winnerRacingCarList) {
        return new WinnerRacingCarList(winnerRacingCarList);
    }

}
