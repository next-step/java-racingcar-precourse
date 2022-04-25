package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car{

    private final Integer MIN_NUMBER = 0;
    private final Integer MAX_NUMBER = 9;
    private final Integer MOVE_NUMBER = 4;

    /**
     * 이름 중복발생시 식별자
     */

    final CarName carName;
    final Mileage mileage;
    final CarId carId;
    private final RecordLine recordLine;

    public Car(String name) {
        this.carId = new CarId();
        this.carName = new CarName(name);
        this.mileage = new Mileage();
        this.recordLine = new RecordLine();
    }

    public void move() {
        if (isGo()) {
            go();
        }

        this.recordLine.writeRecordLine(carName.carName());
    }

    private void go() {
        this.mileage.addMileage();
        this.recordLine.addRecordLine();
    }

    private boolean isGo() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER) >= MOVE_NUMBER;
    }
}
