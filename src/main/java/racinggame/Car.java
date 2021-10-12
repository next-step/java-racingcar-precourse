package racinggame;

public class Car {

    private static final int MAX_LENGTH = 5;
    private static final int RACE_START_NUMBER = 0;
    private static final int RACE_END_NUMBER = 9;
    private static final int ADVANCE_START_NUMBER = 4;

    private String name;
    private int advance;

    public Car(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름은 " + MAX_LENGTH + "자 이하만 가능합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getAdvance() {
        return advance;
    }

    public int racing(int number) {
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException("[ERROR] 이동할 숫자는 " + RACE_START_NUMBER + "부터 " + RACE_END_NUMBER + "의 값이어야 합니다.");
        }
        if (number >= ADVANCE_START_NUMBER) {
            advance++;
        }
        return advance;
    }

    public boolean isValidNumber(int number) {
        return number >= RACE_START_NUMBER && number <= RACE_END_NUMBER;
    }
}
