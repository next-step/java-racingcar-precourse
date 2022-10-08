package racingcar.model.delimiter;

public class FinalWinnerOutputDelimiter implements Delimiter {
    private final String delimiterRegex;

    public FinalWinnerOutputDelimiter(String delimiterRegex) {
        this.delimiterRegex = delimiterRegex;
    }

    @Override
    public String get() {
        return delimiterRegex;
    }
}
