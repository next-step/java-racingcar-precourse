package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;

public class GameView {

    public void printInputCarNames() {
        System.out.println("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInputGameRound() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printExecutionResult() {
        System.out.println("실행 결과");
    }
    public void printGameRoundResult(Cars cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars.getValues()) {
            sb.append(car.getPositionMessage()).append("\n");
        }
        System.out.println(sb);
    }

    public void printFinalWinners(Winners winners) {
        System.out.println(winners.getWinnersMessage());
    }

}
