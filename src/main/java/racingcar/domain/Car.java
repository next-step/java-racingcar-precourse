package racingcar.domain;

import racingcar.constants.EngineOperateType;

public class Car {

    private static final String DISTANCE_DRIVEN_MARK = "-";

    private final Engine engine;
    private final CarName carName;
    private final DistanceDriven distanceDriven;

    public Car(Engine engine, String carName, int distanceDriven) {
        this.engine = engine;
        this.carName = new CarName(carName);
        this.distanceDriven = new DistanceDriven(distanceDriven);
    }

    public static Car createRandomEngineCar(String carName) {
        return new Car(RandomEngine.getInstance(), carName, 0);
    }

    public void drive() {
        EngineOperateType operateType = engine.operate();
        distanceDriven.addDistanceDriven(operateType.getValue());
    }

    public int getDistanceDriven() {
        return distanceDriven.getDistanceDriven();
    }

    @Override
    public String toString() {
        StringBuilder distance = new StringBuilder();
        for (int i = 0; i < getDistanceDriven(); i++) {
            distance.append(DISTANCE_DRIVEN_MARK);
        }
        return getCarName() + " : " + distance;
    }

    public String getCarName() {
        return carName.getCarName();
    }
}
