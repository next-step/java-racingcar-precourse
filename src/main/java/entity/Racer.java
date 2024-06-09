package entity;

import java.math.BigInteger;

public class Racer {
    public BigInteger MOVE_THRESHOLD = new BigInteger("3");
    private String name;

    private BigInteger movedDistance;

    public Racer(String name) {
        this.name = name;
        this.movedDistance = new BigInteger("0");
    }

    public String getName() {
        return name;
    }

    public BigInteger getMovedDistance() {
        return movedDistance;
    }
}
