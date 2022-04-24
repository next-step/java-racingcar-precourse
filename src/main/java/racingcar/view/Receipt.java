package racingcar.view;

public final class Receipt {
    public static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_REPEAT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    private Receipt() {
    }

    public static void printInputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
    }

    public static void printInputRepeatNumber() {
        System.out.println(INPUT_REPEAT_NUMBER_MESSAGE);
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
