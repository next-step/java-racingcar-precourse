package view;

public class UserInputView {

    private final String ALERT_CAR_NAME = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private final String ALERT_MOVE_COUNT = "시도할 회수는 몇회인가요?";

    public void printAlertCarName() {
        System.out.println(ALERT_CAR_NAME);
    }

    public void printAlertMoveCount() {
        System.out.println(ALERT_MOVE_COUNT);
    }
}
