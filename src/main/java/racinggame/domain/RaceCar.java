package racinggame.domain;

import racinggame.utils.RaceValidation;

import java.util.Objects;

public class RaceCar {

    private String name;
    private int moveCount;

    public RaceCar(String name, int moveCount) {
        validation(name);
        this.name = name;
        this.moveCount = moveCount;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getMoveRegex() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < moveCount; i++) {
            sb.append(RaceOperate.MOVE.getRegex());
        }
        return sb.toString();
    }

    public void move() {
        moveCount++;
    }

    private void validation(String name) {
        RaceValidation.validateEmptyName(name);
        RaceValidation.validateLengthOverName(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceCar raceCar = (RaceCar) o;
        return moveCount == raceCar.moveCount && Objects.equals(name, raceCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, moveCount);
    }
}
