package racingcar.view;

public class ErrorView {
    private static final String ERROR = "[ERROR]";

    public static void nameError() {
        System.out.printf("%s 이름은 쉼표(,) 구분합니다. 이름은 5자 이하이며 동일한 이름이 존재할 수 없습니다.\n", ERROR);
    }

    public static void roundError() {
        System.out.printf("%s 시도 횟수는 0 보다 큰 자연수다.\n", ERROR);
    }
}
