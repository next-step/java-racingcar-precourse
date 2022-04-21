package racingcar.view;

public class ErrorView {

    public static void print(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }
}
