package racingcar;

public class CarCollection {

    private static final int MAX_LENGTH = 5;
    private static final String VALUES_DELIMITER = ",";
    private final String[] values;

    public CarCollection(final String concatenatedValue) {
        String[] values = concatenatedValue == null || concatenatedValue.length() == 0 ?
                new String[0] : concatenatedValue.trim().split(VALUES_DELIMITER);

        this.values = this.validate(values);
    }

    public String[] getValues() {
        return this.values;
    }

    private String[] validate(final String[] values) {
        if (values.length == 0) {
            throw new IllegalArgumentException();
        }

        for (String value : values) {
            if (value.length() > MAX_LENGTH) {
                throw new IllegalArgumentException();
            }
        }

        return values;
    }

}
