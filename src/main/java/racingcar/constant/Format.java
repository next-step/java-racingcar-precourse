package racingcar.constant;

public enum Format {
    NUMBER_FORMAT("[-0-9]+");

    private final String format;

    Format(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
