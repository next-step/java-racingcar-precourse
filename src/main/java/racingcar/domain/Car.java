package racingcar.domain;

import racingcar.constants.EngineOperateType;

public class Car {

    private final Engine engine;
    private final CarName carName;
    private final DistanceDriven distanceDriven;

    public Car(Engine engine, String carName, int distanceDriven) {
        this.engine = engine;
        this.carName = new CarName(carName);
        this.distanceDriven = new DistanceDriven(distanceDriven);
    }

    public void drive() {
        EngineOperateType operateType = engine.operate();
        distanceDriven.addDistanceDriven(operateType.getValue());
    }

    public int getDistanceDriven() {
        return distanceDriven.getDistanceDriven();
    }
}
