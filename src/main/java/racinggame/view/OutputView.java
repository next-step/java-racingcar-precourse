package racinggame.view;

import racinggame.domain.RaceCar;

public class OutputView {

    public void printRaceRound(RaceCar raceCar) {
        System.out.println(raceCar.getName() + " : " + raceCar.getMoveRegex());
    }

    public void printRaceWinner(String winner) {
        System.out.println("최종 우승자는 " + winner + " 입니다.");
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

}
