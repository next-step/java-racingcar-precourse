package racingcar.domain;

import racingcar.common.NaturalNumber;
import racingcar.common.UserString;

public class DriveRecord {
    
    private final CarName carName;
    private final NaturalNumber carPosition;

    public DriveRecord(CarName carName, NaturalNumber position) {
        this.carName = carName;
        this.carPosition = position;
    }

    public boolean isAt(NaturalNumber position) {
        return this.carPosition.isSame(position);
    }

    public NaturalNumber getCarPosition() {
        return carPosition;
    }

    public UserString getName() {
        return UserString.of(carName.toString());
    }

    public boolean hasName(CarName car1) {
        return this.carName.equals(car1);
    }

    public DriveRecord copy() {
        return new DriveRecord(this.carName, this.carPosition);
    }

    public boolean isGreaterThan(NaturalNumber maxPosition) {
        return this.carPosition.isGreaterThan(maxPosition);
    }
}
