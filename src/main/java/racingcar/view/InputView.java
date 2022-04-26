package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getRacingCarNames() {
        try {
            System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분) 입력 해 주세요.");
            return inputCarNames();
        } catch (IllegalArgumentException e) {
            PrintView.printErrorMessage(e.getMessage());
            return getRacingCarNames();
        }
    }

    private static String inputCarNames() {
        String carNames = Console.readLine();
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("빈값을 입력할 수 없습니다.");
        }
        return carNames;
    }

    public static int getGameRound() {
        try {
            System.out.println("시도할 회수 입력해 주세요.");
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            PrintView.printErrorMessage("숫자만 입력이 가능합니다.");
            return getGameRound();
        }
    }

}

