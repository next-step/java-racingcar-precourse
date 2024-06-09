package entity;

import java.math.BigInteger;

public class Racer {
    public static BigInteger MOVE_THRESHOLD = new BigInteger("3");

    public static String VALIDATE_NAME_ERROR_MESSAGE = "name은 null이거나 빈 문자열일 수 없습니다.";

    private String name;

    private BigInteger movedDistance;

    public Racer(String name) {
        this.name = validateName(name);
        this.movedDistance = new BigInteger("0");
    }

    private String validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(VALIDATE_NAME_ERROR_MESSAGE);
        }

        return name.trim();
    }

    public String getName() {
        return name;
    }

    public BigInteger getMovedDistance() {
        return movedDistance;
    }
}
