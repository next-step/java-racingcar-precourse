package racingcar.Model.Racing.Movement;

import racingcar.Util.Constant;

import java.util.List;

public class Movements {
    private final List<Movement> movementList;
    private int goAmount = Constant.INITIALAMOUNT;

    public Movements(List<Movement> movementList) {
        this.movementList = movementList;
    }

    public void addMovement(Movement movement) {
        this.movementList.add(movement);
    }

    public int countNumberOfGo() {
        this.movementList.forEach(this::countGo);

        return this.goAmount;
    }

    private void countGo(Movement movement) {
        if (movement.isGo(movement)) {
            this.goAmount++;
        }
    }

    public Movements sliceMovements(int fromIndex, int toIndex) {
        return new Movements(this.movementList.subList(fromIndex, toIndex));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Movement movement : this.movementList) {
            stringBuilder.append(movement.isGo(movement) ? "-" : "");
        }

        return stringBuilder.toString();
    }
}
