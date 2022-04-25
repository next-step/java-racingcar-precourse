package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static String inputCarNameWithComma() {
        String carNames = "";
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            try {
                carNames = Console.readLine();
                if (!validInputValue(carNames)) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println("[ERROR] 입력값이 잘못되었습니다.");
            }
        }
        return carNames;
    }

    private static boolean validInputValue(String carNames) {
        String[] carNamesArray = carNames.split(",");
        for (String value : carNamesArray) {
            if (value.isEmpty()) {
                return false;
            }
            if (value.length() == 0 || value.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public static int inputNumberOfAttempts(){
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
