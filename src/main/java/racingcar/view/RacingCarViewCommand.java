package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.GameStatus;

import java.util.List;

public class RacingCarViewCommand implements RacingCarView {
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_RUN_COUNT = "시도할 회수는 몇회인가요?";
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String RESULT_DELIMITER = " : ";
    private static final String FINAL_WINNER = "최종 우승자: ";
    private static final String ERROR_PREFIX_MESSAGE = "[ERROR] ";

    @Override
    public void printInputCarName() {
        System.out.println(INPUT_CAR_NAME);
    }

    @Override
    public void printInputRunCount() {
        System.out.println(INPUT_RUN_COUNT);
    }

    @Override
    public void printStatus(List<GameStatus> status, Cars player) {
        printExecuteResult();
        for (int i=0; i < status.size(); i++) {
            printStatusByStep(status, player, i);
            printNewLine();
        }
    }

    private void printExecuteResult() {
        System.out.println(EXECUTION_RESULT);
    }

    private void printStatusByStep(List<GameStatus> status, Cars player, int i) {
        List<Integer> result = status.get(i).getGameStatus();
        for(int j=0; j < result.size(); j++) {
            printCarName(player.carList().get(j).getCarName());
            printDelimiter();
            printPosition(result.get(j));
            printNewLine();

        }
    }

    private void printDelimiter() {
        System.out.print(RESULT_DELIMITER);
    }

    private void printCarName(String carName) {
        System.out.print(carName);
    }

    private void printPosition(Integer position) {
        for (int i=0; i < position; i++) {
            System.out.print("-");
        }
    }

    public void printWinner(String winner) {
        System.out.print(FINAL_WINNER + winner);
    }

    @Override
    public void printError(String message) {
        System.out.println(ERROR_PREFIX_MESSAGE + message);
    }

    private void printNewLine() {
        System.out.println();
    }
}
