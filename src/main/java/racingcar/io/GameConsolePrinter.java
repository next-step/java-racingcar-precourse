package racingcar.io;

import racingcar.domain.cars.Cars;
import racingcar.domain.cars.WinnerCars;

public class GameConsolePrinter implements GamePrinter {

    private final static String CAR_NAME_INFO = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String COUNT_INFO = "시도할 회수는 몇회인가요?";
    private final static String ROUND_RESULT = "실행 결과";
    private final static String WINNER = "최종 우승자: ";

    @Override
    public void printCarNameInfo() {
        System.out.println(CAR_NAME_INFO);
    }

    @Override
    public void printCountInfo() {
        System.out.println(COUNT_INFO);
    }

    @Override
    public void printRoundResultPrefix() {
        System.out.println(ROUND_RESULT);
    }

    @Override
    public void printRoundResult(Cars cars) {
        System.out.println(cars.toStatusString());
    }

    @Override
    public void printWinner(WinnerCars winnerCars) {
        System.out.print(WINNER);
        System.out.print(winnerCars.toWinnerString());
    }
}
