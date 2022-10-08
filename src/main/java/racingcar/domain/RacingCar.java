package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private final CarName name;
    private final CarOffset offset;

    private RacingCar(CarName name, CarOffset offset) {
        this.name = name;
        this.offset = offset;
    }

    public String getName() {
        return name.getName();
    }

    public static RacingCar of(String name) {
        return new RacingCar(CarName.of(name), new CarOffset());
    }

    public void move() {
        if (canMove()) {
            offset.increaseOffset();
        }
    }

    public Integer getOffset() {
        return offset.getOffset();
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
