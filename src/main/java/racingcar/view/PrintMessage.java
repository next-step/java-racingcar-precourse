package racingcar.view;

public enum PrintMessage {

    CAR_NAMES_FORM_INFO("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ROUND_COUNT_FORM_INFO("시도할 횟수는 몇회인가요?"),
    ROUND_RESULT_INFO("실행 결과"),
    WINNERS_INFO("최종 우승자 : ");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    } 

    public void print() {
        System.out.print(message);
    }

    public void println() {
        System.out.print(message);
    }

    public static void newLine() {
        System.out.println();
    }

    public static void custom(String message) {
        System.out.println(message);
    }
}
