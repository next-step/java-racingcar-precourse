package exception;

public class ExceptionHandler {
    public static void showErrorMsg(Exception error) {
        System.out.println(error.getMessage());
        System.out.println();
    }
}
