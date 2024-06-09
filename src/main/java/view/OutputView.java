package view;

public class OutputView {
    public static void printMessage(String message) {
        StringBuilder sb = new StringBuilder(message);
        System.out.println(sb.toString());
    }
}
