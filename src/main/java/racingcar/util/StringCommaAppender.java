package racingcar.util;

public class StringCommaAppender extends StringAppender {

    private static final String COMMA = ",";
    private static final String BLANK = " ";

    public StringCommaAppender(String str) {
        super(str);
    }

    @Override
    public void append(String str) {
        if (!"".equals(get())) {
            super.append(COMMA);
            super.append(BLANK);
        }
        super.append(str);
    }

    @Override
    public String get() {
        return super.get();
    }
}
