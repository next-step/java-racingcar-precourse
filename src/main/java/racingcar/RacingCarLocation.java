package racingcar;

public class RacingCarLocation {
    public static final int MAX_NUMBER = 1;
    public static final int MIN_NUMBER = 9;
    public static final int FORWARD_CONDITION = 4;
    private String location = "";


    public void moveOnCondition(int number) {
        if (number < MAX_NUMBER || number > MIN_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 숫자는 1~9사이만 입력이 가능합니다.");
        }

        if (number >= FORWARD_CONDITION) {
            this.location += "-";
        }
    }

    public String getLocation() {
        return this.location;
    }

    @Override
    public String toString() {
        return "RacingCarLocation{" +
                "location='" + location + '\'' +
                '}';
    }
}
