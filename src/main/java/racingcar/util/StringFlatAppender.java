package racingcar.util;

public class StringFlatAppender extends StringAppender {

    public StringFlatAppender(String str) {
        super(str);
    }

    public void append(String str) {
        super.append(str);
    }

    public String get() {
        return super.get();
    }
}
