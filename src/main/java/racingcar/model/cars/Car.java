package racingcar.model.cars;

import java.util.Objects;
import racingcar.model.cars.factory.Engine;
import racingcar.model.cars.factory.MoveEvent;
import racingcar.model.cars.factory.MoveHistory;
import racingcar.model.cars.factory.Title;

public class Car {
    private final Title title;
    private final Engine engine;
    private final MoveHistory moveHistory;

    public Car(Title title, Engine engine, MoveHistory moveHistory) {
        this.title = title;
        this.engine = engine;
        this.moveHistory = moveHistory;
    }

    public Title getTitle() {
        return title;
    }

    public MoveHistory getMoveHistory() {
        return moveHistory;
    }

    public void move() {
        MoveEvent moveEvent = engine.run();
        moveHistory.add(moveEvent);
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this.toString(), obj.toString()) && getClass() == obj.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + String.format("[title=%s]", this.getTitle().get());
    }
}
