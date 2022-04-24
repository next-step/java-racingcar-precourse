package racingcar.view;


import camp.nextstep.edu.missionutils.Console;

public class UserInputView {

    private static final String CAR_INPUT_MESSAGE = "경주할자동차이름(이름은쉼표(,)기준으로구분)";
    private static final String COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public String inputCarNameMessage() {
        System.out.println(String.format("\n%s", CAR_INPUT_MESSAGE));
        return Console.readLine();
    }

    public String inputCountMessage() {
        System.out.println(String.format("\n%s", COUNT_INPUT_MESSAGE));
        return Console.readLine();
    }

}
