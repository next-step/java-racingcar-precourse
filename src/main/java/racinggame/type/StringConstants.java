package racinggame.type;

public enum StringConstants {
    NAME_SEPARATOR(","),
    LINE_FEED("\n"),
    ERROR_TAG("[ERROR]");

    private final String value;

    StringConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
