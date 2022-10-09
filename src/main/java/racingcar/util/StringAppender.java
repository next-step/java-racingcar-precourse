package racingcar.util;

public abstract class StringAppender {

    private final StringBuilder sb;

    public StringAppender(String str) {
        sb = new StringBuilder(str);
    }

    public void append(String str) {
        sb.append(str);
    }

    public String get() {
        return sb.toString();
    }
}
