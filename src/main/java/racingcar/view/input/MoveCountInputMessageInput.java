package racingcar.view.input;

public class MoveCountInputMessageInput implements InputPrintMessage {
    private static final String TRIAL_COUNT = "시도할 횟수";

    @Override
    public void messageOutput() {
        System.out.println(TRIAL_COUNT);
    }
}
