package racingcar.view.input;

public class RacingCarInputMessageInput implements InputPrintMessage {
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주 할 자동차 이름 (이름은 쉼표(,) 기준으로 구분)";

    @Override
    public void messageOutput() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
    }
}
