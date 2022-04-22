package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.StringJoiner;
import racingcar.car.RacingCarDTO;
import racingcar.car.RacingCarName;

public class RacingGameViewWithNsConsole implements RacingGameView {
    private static final String DASH = "-";
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACING_STAGE_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_HEADER = "실행 결과";
    private static final String CAR_POSITION_MESSAGE_FORMAT = "%s : %s\n";
    private static final String WINNER_LIST_DELIMITER = ", ";
    private static final String WINNER_MESSAGE_FORMAT = "최종 우승자: %s\n";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s\n";

    @Override
    public String takeRacingCarNames() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        return Console.readLine();
    }

    @Override
    public String takeRacingStageCount() {
        System.out.println(RACING_STAGE_COUNT_INPUT_MESSAGE);
        return Console.readLine();
    }

    @Override
    public void printStageStart() {
        System.out.println(RESULT_HEADER);
    }

    @Override
    public void printStageResult(List<RacingCarDTO> racingCarDTOList) {
        for (RacingCarDTO racingCarDTO : racingCarDTOList) {
            System.out.printf(CAR_POSITION_MESSAGE_FORMAT, racingCarDTO.getName(),
                    makeLineMessageFromPosition(racingCarDTO.getPosition()));
        }
        System.out.println();
    }

    @Override
    public void printWinner(List<RacingCarName> winners) {
        StringJoiner joiner = new StringJoiner(WINNER_LIST_DELIMITER);
        for (RacingCarName winner : winners) {
            joiner.add(winner.getName());
        }
        System.out.printf(WINNER_MESSAGE_FORMAT, joiner.toString());
    }

    private String makeLineMessageFromPosition(int position) {
        String lineMessage = "";
        for (int i = 0; i < position; i++) {
            lineMessage += DASH;
        }
        return lineMessage;
    }


    @Override
    public void printErrorMessage(Exception e) {
        System.out.printf(ERROR_MESSAGE_FORMAT, e.getMessage());
    }
}
