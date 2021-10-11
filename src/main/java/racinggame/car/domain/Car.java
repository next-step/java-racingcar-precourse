package racinggame.car.domain;

import racinggame.race.domain.Position;
import racinggame.race.utils.CarEngineUtil;

public class Car {
    private final CarName name;
    private final Position position;

    public Car(CarName name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void confirmCarEngine() {
        if(CarEngineUtil.canEngineRunConfirm(CarEngineUtil.getNumber())) {
            position.addPosition();
        }
    }
}
