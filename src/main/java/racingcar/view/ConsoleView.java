package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.MoveResult;
import racingcar.domain.Victors;

public class ConsoleView implements View {
    private static final String REQUEST_INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_INPUT_RACING_COUNT_MESSAGE = "시도할 회수는 몇 회인가요?";
    private static final String VICTOR_GUIDE_MESSAGE = "최종 우승자: ";
    private static final String EXECUTION_RESULT_GUIDE_MESSAGE = "실행 결과";

    private static final String RACING_COUNT_NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자만 입력 합니다.";
    private static final String RACING_COUNT_NEGATIVE_ERROR_MESSAGE = "[ERROR] 시도 횟수는 0이상 입력 가능합니다.";

    private static final int MIN_RACING_COUNT = 1;

    @Override
    public String requestInputCarNames() {
        System.out.println(REQUEST_INPUT_CAR_NAME_MESSAGE);
        return Console.readLine();
    }

    @Override
    public int requestInputRacingCount() {
        try {
            System.out.println(REQUEST_INPUT_RACING_COUNT_MESSAGE);
            int inputRacingCount = Integer.parseInt(Console.readLine());
            validateRacingCount(inputRacingCount);
            return inputRacingCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(RACING_COUNT_NOT_NUMBER_ERROR_MESSAGE, e);
        }
    }

    @Override
    public void outputMoveResult(MoveResult moveResult) {
        System.out.println(moveResult);
    }

    @Override
    public void outputVictors(Victors victors) {
        System.out.println(VICTOR_GUIDE_MESSAGE + victors);
    }

    @Override
    public void errorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    @Override
    public void outputExecutionResultGuide() {
        System.out.println(EXECUTION_RESULT_GUIDE_MESSAGE);
    }

    private void validateRacingCount(int inputRacingCount) {
        if (inputRacingCount < MIN_RACING_COUNT) {
            throw new IllegalArgumentException(RACING_COUNT_NEGATIVE_ERROR_MESSAGE);
        }
    }
}
