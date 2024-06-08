package racingCar.view;

import racingCar.validation.InputValidator;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_NAME_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_NUM_MSG = "시도할 횟수는 몇회인가요?";

    /**
     * 자동차 이름을 입력 받는 메서드
     * 잘못된 값 입력 시 다시 입력 받는다.
     * @return 입력된 자동차 이름들
     */
    public static String inputCarName() {
        String carNames;
        Scanner scanner = new Scanner(System.in);

        while(true) {
            try {
                System.out.println(INPUT_CAR_NAME_MSG);
                carNames = scanner.nextLine();
                InputValidator.validateInputCarName(carNames);
                break;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return carNames;
    }

    /**
     * 시도할 횟수를 입력 받는 메서드
     * 잘못된 값 입력 시 다시 입력 받는다.
     * @return 시도할 횟수
     */
    public static String inputTryNum() {
        String tryNum;
        Scanner scanner = new Scanner(System.in);

        while(true) {
            try {
                System.out.println(INPUT_TRY_NUM_MSG);
                tryNum = scanner.nextLine();
                InputValidator.validateInputTryNum(tryNum);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return tryNum;
    }
}
