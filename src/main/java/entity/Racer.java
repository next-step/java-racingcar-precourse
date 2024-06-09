package entity;

import java.math.BigInteger;

public class Racer {
    public static final int NAME_MAX_LENGTH = 5;

    public static final BigInteger MOVE_THRESHOLD = new BigInteger("3");

    public static final String VALIDATE_NAME_ERROR_MESSAGE = "name은 null이거나 빈 문자열일 수 없습니다. 그리고 " + NAME_MAX_LENGTH + "자 이하 여야합니다.";

    private String name;

    private BigInteger movedDistance;

    /**
     * @throws IllegalArgumentException name이 null이거나 blank 문자열 일 때
     */
    public Racer(String name) {
        this.name = validateName(name);
        this.movedDistance = new BigInteger("0");
    }

    public void moveIfCan(BigInteger input) {
        if(input.compareTo(MOVE_THRESHOLD) > 0) {
            movedDistance = movedDistance.add(new BigInteger("1"));
        }
    }

    public boolean isWinner(BigInteger input) {
        return input.compareTo(movedDistance) <= 0;
    }

    public String getName() {
        return name;
    }

    public BigInteger getMovedDistance() {
        return movedDistance;
    }

    private String validateName(String name) {
        if (name == null || name.isBlank() || name.trim().length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(VALIDATE_NAME_ERROR_MESSAGE);
        }

        return name.trim();
    }
}
