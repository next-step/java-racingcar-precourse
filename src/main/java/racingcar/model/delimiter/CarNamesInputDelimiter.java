package racingcar.model.delimiter;

public class CarNamesInputDelimiter implements Delimiter {
    private final String delimiterRegex;

    public CarNamesInputDelimiter(String delimiterRegex) {
        this.delimiterRegex = delimiterRegex;
    }

    @Override
    public String get() {
        return delimiterRegex;
    }
}
