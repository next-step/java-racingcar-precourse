package racingcar.model;

import racingcar.model.primitive.LapInfo;
import racingcar.model.primitive.Name;
import racingcar.util.Utils;

public class Car {
    private Name name;
    private LapInfo lapInfo;

    private Car(String name) {
        this.lapInfo = new LapInfo("");
        this.name = new Name(name);
    }

    public static Car withName(String name) {
        return new Car(name);
    }

    public String getName() {
        return this.name.getName();
    }

    public String getLapInfo() {
        return this.lapInfo.getLapInfo();
    }

    public void update() {

        if (Utils.getRandom(0, 9) > 3) {
            this.lapInfo.addLap();
        }
    }

    public String getLaps() {
        return getName() + " : " + getLapInfo();
    }
}