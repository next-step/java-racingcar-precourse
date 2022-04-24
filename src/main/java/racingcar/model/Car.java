package racingcar.model;

import racingcar.constant.Digit;
import racingcar.constant.ErrorMessage;
import racingcar.constant.Sign;

public class Car {

    private final CarName name;
    private Headway headway;

    Car(String carName) {
        this.headway = new Headway();
        this.name = this.mapCarName(carName);
    }

    private CarName mapCarName(String carName) {
        return new CarName(carName);
    }

    public String getCarName() {
        return this.name.getCarName();
    }

    public int getHeadway() {
        return this.headway.getHeadway();
    }

    public void drive(int engine) {
        if (engine > Digit.STANDARD_ENGIN.getNumber()) {
            this.headway.addHeadway();
        }
    }

    public String getStatus() {
        StringBuffer status = new StringBuffer(getCarName());
        status.append(Sign.CONNECTION_SIGN.getSign());
        status.append(this.headway.getHeadwaySign());
        return status.toString();
    }

    public boolean isEqualHeaday(int maxHeadway) {
        return this.headway.isEqual(maxHeadway);
    }

    public void validateCarNamesIsEqual(String carNames) {
        if (this.name.isEqual(carNames)) {
            throw new IllegalArgumentException(ErrorMessage.OVERLAP_CAR_NAME.getMessage());
        }
    }
}
