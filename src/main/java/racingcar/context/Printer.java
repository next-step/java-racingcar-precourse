package racingcar.context;

public interface Printer {
    void print(String text);
    void println(String text);
    default void println() {
        println("");
    }
}
