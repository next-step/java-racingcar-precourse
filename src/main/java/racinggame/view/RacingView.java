package racinggame.view;

import nextstep.utils.Console;

public class RacingView {
    private final String INPUT_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_TRY_NUMBER = "시도할 회수는 몇회인가요?";
    private final String PLAY_RESULT = "실행결과";
    private final String GO_STATUS = "-";

    public void printInputCarsName() {
        System.out.println(INPUT_CARS_NAME);
    }

    public String inputCarsName() {
        return Console.readLine();
    }

    public void printInputTryNumber() {
        System.out.println(INPUT_TRY_NUMBER);
    }

    public String inputTryNumber() {
        return Console.readLine();
    }

    public void printPlayResult() {
        System.out.println(PLAY_RESULT);
    }

    public void printGoStatus(int score) {
        for(int i = 0; i < score; i++) {
            System.out.print(GO_STATUS);
        }
        System.out.println();
    }
}
