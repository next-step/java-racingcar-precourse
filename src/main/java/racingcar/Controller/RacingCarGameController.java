package racingcar.Controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingcarModel;

public class RacingCarGameController {
    private static final String STR_INPUT_CAR_NAME_MSG = "경주 할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String STR_INPUT_TRY_CNT_MSG = "시도할 회수는 몇회인가요?";
    private static final String STR_RESULT_MSG = "실행 결과";
    private static final String STR_ERROR_INPUT_CRY_COUNT_STRING = "[ERROR] 시도 횟수는 숫자여야 합니다.";
    private static final String STR_ERROR_INPUT_CRY_COUNT_MINUS = "[ERROR] 시도 횟수는 양수여야 합니다.";

    public static RacingcarModel racingModel;
    private static int mGameTryCnt = 0;

    public static void run() {
        racingModel = new RacingcarModel();
        inputCarName();
        inputTryCount();
        processRacingCarGame();
        printVictoryCar();
    }

    private static void inputCarName() {
        while (true) {
            System.out.println(STR_INPUT_CAR_NAME_MSG);
            String inputCarStr = Console.readLine();
            if (racingModel.inputCarFromString(inputCarStr)) break;
        }
    }

    private static void inputTryCount() {
        while (true) {
            System.out.println(STR_INPUT_TRY_CNT_MSG);
            try {
                mGameTryCnt = ConvertInputStrToInt(Console.readLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
    }

    private static int ConvertInputStrToInt(String input) {
        int res;
        try {
            res = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(STR_ERROR_INPUT_CRY_COUNT_STRING);
        }
        if (res < 0) throw new IllegalArgumentException(STR_ERROR_INPUT_CRY_COUNT_MINUS);
        return res;
    }

    private static void processRacingCarGame() {
        System.out.println(STR_RESULT_MSG);
        for (int i = 0; i < mGameTryCnt; i++) {
            racingModel.runCarOnce();
            racingModel.printCarPosition();
            System.out.println();
        }
    }

    private static void printVictoryCar() {
        System.out.println("최종 우승자 : " + racingModel.getForefrontCarName());
    }
}
