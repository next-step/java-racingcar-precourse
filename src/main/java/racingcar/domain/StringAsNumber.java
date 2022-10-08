package racingcar.domain;

public class StringAsNumber extends Number {
    private final String text;

    public StringAsNumber(final String text) {
        this.text = text;
    }

    @Override
    public int intValue() {
        int value;
        try {
            value = Integer.parseInt(this.text);
        } catch (Exception e) {
            throw new IllegalArgumentException("옳바르지 않은 입력입니다.");
        }
        return value;
    }

    @Override
    public long longValue() {
        long value;
        try {
            value = Long.parseLong(this.text);
        } catch (Exception e) {
            throw new IllegalArgumentException("옳바르지 않은 입력입니다.");
        }
        return value;
    }

    @Override
    public float floatValue() {
        float value;
        try {
            value = Float.parseFloat(this.text);
        } catch (Exception e) {
            throw new IllegalArgumentException("옳바르지 않은 입력입니다.");
        }
        return value;
    }

    @Override
    public double doubleValue() {
        double value;
        try {
            value = Double.parseDouble(this.text);
        } catch (Exception e) {
            throw new IllegalArgumentException("옳바르지 않은 입력입니다.");
        }
        return value;
    }
}
