package racingcar.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Cars {
    private final List<Car> value;

    public Cars(Names names) {
        this.value = new LinkedList<>();
        generateCars(names);
    }

    public int size() {
        return this.value.size();
    }

    private void generateCars(Names names) {
        for (Name name : names.getValue()) {
            this.value.add(new Car(name));
        }
    }

    public List<Car> getValue() {
        return Collections.unmodifiableList(value);
    }

    public void moveAll() {
        for (Car car : value) {
            car.move(MovementPolicy.action());
        }
    }

    public Names getMostMovedNames() {
        Position maximumPosition = getPositions().getMaximumPosition();
        return getNamesBy(maximumPosition);
    }

    private Positions getPositions() {
        List<Position> positionValues = new LinkedList<>();
        for (Car car : value) {
            positionValues.add(car.getPosition());
        }
        return new Positions(positionValues);
    }

    private Names getNamesBy(Position maximumPosition) {
        List<Name> nameList = new LinkedList<>();
        for (Car car : value) {
            setNameByPosition(nameList, car, maximumPosition);
        }
        return new Names(nameList);
    }

    private void setNameByPosition(List<Name> nameList, Car car, Position maximumPosition) {
        if (car.getPosition().equals(maximumPosition)) {
            nameList.add(new Name(car.getName()));
        }
    }
}
