package view;

import java.util.*;
import utils.InputValidator;

/**
 * 입력을 담당하는 클래스
 */
public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_COUNT = "시도할 회수는 몇회인가요?";

    public static void setScanner (Scanner scanner) {
        InputView.scanner = scanner;
    }

    /**
     * 사용자로부터 자동차의 이름들을 입력 받는 메서드
     *
     * @return 자동차 이름 리스트
     */
    public static List<String> inputCarNames() {

        // 사용자 입력
        System.out.println(INPUT_CAR_NAMES);
        String carNames = scanner.nextLine();
        List<String> carNameList = Arrays.asList(carNames.split(","));

        // 입력값 검증
        try {
            InputValidator.validateCarNames(carNameList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCarNames(); // 에러 발생 시 다시 입력 받음
        }

        return carNameList;
    }

    /**
     * 사용자로부터 시도 횟수를 입력 받는 메서드
     * @return 시도 횟수
     */
    public static int inputAttemptCount() {

            // 사용자 입력
            System.out.println(INPUT_ATTEMPT_COUNT);
            String attemptCount = scanner.nextLine();

            // 입력값 검증
            try {
                InputValidator.validateAttemptCount(attemptCount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return inputAttemptCount(); // 에러 발생 시 다시 입력 받음
            }

            return Integer.parseInt(attemptCount);
    }
}
