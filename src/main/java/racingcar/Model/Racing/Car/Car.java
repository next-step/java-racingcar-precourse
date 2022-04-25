package racingcar.Model.Racing.Car;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.Racing.Movement.Movement;
import racingcar.Model.Racing.Movement.Movements;

import java.util.ArrayList;

public class Car {
    private final String name;
    private final Movements movements;
    private int amountOfGO;

    public Car(String name) {
        this.name = name;
        this.movements = new Movements(new ArrayList<>());
    }

    public void move() {
        this.movements.addMovement(Movement.move(Randoms.pickNumberInRange(0, 9)));
    }

    public String getName() {
        return this.name;
    }

    public void setAmountOfGO() {
        this.amountOfGO = this.movements.countNumberOfGo();
    }

    public int getAmountOfGO() {
        return this.amountOfGO;
    }

    public boolean isEqualMaxAmountOfGO(int maxAmountOfGO) {
        return maxAmountOfGO == this.amountOfGO;
    }

    public String getMovementStatusString(int fromIndex, int toIndex) {
        return String.format("%s : %s", this.name, this.movements.sliceMovements(fromIndex, toIndex).toString());
    }
}
