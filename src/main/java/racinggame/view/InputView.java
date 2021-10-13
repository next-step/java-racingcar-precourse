package racinggame.view;

import nextstep.utils.Console;
import racinggame.utils.ValidationUtils;

public class InputView {
    private static final String ERROR_MESSAGE = "[ERROR]";

    // 자동차 이름 입력받기
    public String inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String names = Console.readLine();
        while (!validateCarsNames(names))
        {
            System.out.println(ERROR_MESSAGE);
            names = Console.readLine();
        }
        return names;
    }
    // 자동차 이름 유효성 검사
    private boolean validateCarsNames(String names) {
        if (!ValidationUtils.validateCarsNames(names)) {
            System.out.println(ERROR_MESSAGE + " 자동차 이름은 5글자 이하로 입력해주세요.");
            return false;
        }
        if (ValidationUtils.duplicateCarNames(names)) {
            System.out.println(ERROR_MESSAGE + " 중복되지 않는 자동차 이름을 이력해주세요.");
            return false;
        }
        return true;
    }

    // 시도횟수 입력받기
    public int inputTryNo() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String tryNo = Console.readLine();
        while(!validateTryNo(tryNo)) {
            tryNo = Console.readLine();
        }
        return Integer.parseInt(tryNo);
    }

    private boolean validateTryNo(String tryNo) {
        if (!ValidationUtils.validateTryNo(tryNo)) {
            System.out.println(ERROR_MESSAGE + " 시도 횟수는 1 이상의 숫자만 입력해주세요.");
            return false;
        }
        return true;
    }
}
