package racingcar.view;

import java.util.List;
import racingcar.model.Cars;

public interface View {
    String INPUT_MESSAGE_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    String INPUT_MESSAGE_ATTEMPTS = "시도할 회수는 몇회인가요?\n";
    String OUTPUT_MESSAGE_ROUND_RESULT = "실행 결과\n";
    String OUTPUT_MESSAGE_FORMAT_CAR_FORWARD_RESULT = "%s : %s\n";
    String OUTPUT_MESSAGE_FORMAT_WINNER = "최종 우승자 : ";
    String ERROR_MESSAGE_FORMAT = "[ERROR] %s\n";
    String COMMA = ",";
    int MAXIMUM_NAME_LENGTH = 5;

    void printCarNameInputMessage();

    void printAttemptsInputMessage();

    void printRoundResultMessage();

    void printCarForwardResult(Cars cars);

    void printWinner(List<String> winnerNames);

    void printErrorMessage(String message);
}
