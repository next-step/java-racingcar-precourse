package racinggame.domain;

public class NumberOfMoves {

    private final int value;

    public NumberOfMoves(final String value) {
        this.value = parseValue(value);
        validate();
    }

    private int parseValue(final String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("[ERROR] 숫자 외 문자는 입력할 수 없습니다.");
        }
    }

    private void validate() {
        if (this.value <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도할 회수는 0보다 작거나 같을 수 없습니다.");
        }
    }

    public int getValue() {
        return this.value;
    }
}
