package racingcar.model.car;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.GameRule;

public class Car {


    private CarName carName;
    private List<Position> positions;

    public Car(String inputCarName) {
        this.carName = new CarName(inputCarName);
        this.positions = new ArrayList<>();
    }

    public void moveCar(GameRule gameRule) {
        for (int i = 0; i < gameRule.getTryCount(); i++) {
            positions.add(new Position(gameRule.canGoForward()));
        }
    }

    public String getCarName() {
        return this.carName.getCarName();
    }

    public List<Position> getPosition() {
        return positions;
    }

    public int getCurrentPosition(int indexOfPosition) {
        int sum = 0;
        for (int index = 0; index <= indexOfPosition; index++) {
            sum += positions.get(index).getPosition();
        }
        return sum;
    }

    public int getSumPositions() {
        int sum = 0;
        for (Position position : positions) {
            sum += position.getPosition();
        }
        return sum;
    }

    public Car getWinnerCar(Car comparableCar) {

        if (comparableCar == null) {
            return this;
        }

        if (comparableCar.getCarName() == null) {
            return this;
        }

        if (comparableCar.getSumPositions() > getSumPositions()) {
            return comparableCar;
        }
        return this;
    }

    public boolean isJointWinner(Car comparableCar) {
        if (getSumPositions() == comparableCar.getSumPositions()) {
            return true;
        }
        return false;
    }

}
