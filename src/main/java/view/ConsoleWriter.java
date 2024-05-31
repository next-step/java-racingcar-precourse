package view;

public class ConsoleWriter {
    public static void printlnMessage(String message) {
        System.out.println(message);
    }

    public static void printlnFormat(String format, Object... args) {
        System.out.printf(format + "%n", args);
    }

    public static void println() {
        System.out.println();
    }
}