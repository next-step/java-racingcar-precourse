package racingcar.model.car;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.car.distance.ForwardDistance;
import racingcar.model.car.distance.Rpm;
import racingcar.model.car.name.CarName;
import racingcar.model.record.Record;

public class RacingCar{
    private final CarName carName;
    private final ForwardDistance forwardDistance;

    public RacingCar(CarName carName) {
        this.carName = carName;
        this.forwardDistance = new ForwardDistance();
    }

    public void race() {
        hitRpm();
    }

    private void hitRpm() {
        forwardDistance.hitFrom(rpm());
    }

    private Rpm rpm() {
        return new Rpm(
                Randoms.pickNumberInRange(
                        Rpm.MinRpmLevel(),
                        Rpm.MaxRpmLevel()
                ));
    }

    public Record record() {
        return new Record(carName, forwardDistance);
    }
}
