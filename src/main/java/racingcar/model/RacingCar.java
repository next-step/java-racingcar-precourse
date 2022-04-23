package racingcar.model;

import java.util.List;

public class RacingCar {

    private Name name;
    private Position position;
    private PositionHistories positionHistories;

    public RacingCar(String name) {
        this.name = Name.from(name);
        this.position = new Position();
        this.positionHistories = new PositionHistories();
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            this.position.move();
        }
        addPositionHistory();
    }

    private void addPositionHistory() {
        this.positionHistories.add(position);
    }

    public List<Integer> getPositionHistories() {
        return this.positionHistories.getPositionHistories();
    }

    public String getName() {
        return this.name.getName();
    }

    public int equalsAndReturnBigNumber(int winnerPosition) {
        if (this.position.lessThan(winnerPosition)) {
            return winnerPosition;
        }
        return this.position.getPosition();
    }

    public Position getPosition() {
        return position;
    }

    public void findCarNameByPosition(List<String> carNameList, int winnerPosition) {
        if (this.position.isEquals(winnerPosition)) {
            carNameList.add(this.name.getName());
        }
    }
}
