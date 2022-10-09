package racingcar.model.cars;

public class CarNamesAnalyzer {
    private final int minLength;
    private final int maxLength;
    private final String separator;

    private CarNamesAnalyzer(int minLength, int maxLength, String separator) {
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.separator = separator;
    }

    public static CarNamesAnalyzer getInstance() {
        return new CarNamesAnalyzer(1, 5, ",");
    }

    public String[] getNamesArray(String names) {
        return names.split(this.getSeparator());
    }

    public int getMinLength() {
        return minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public String getSeparator() {
        return separator;
    }
}
