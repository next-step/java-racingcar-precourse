package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final Name name;
    private PositionVo position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = PositionVo.zero();
    }

    public String getName() {
        return name.get();
    }

    public int getPosition() {
        return position.get();
    }

    public String toStatusString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name.get()).append(" : ");
        for (int i = 0; i < position.get(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public boolean move() {
        if (Randoms.pickNumberInRange(0, 9) <= 3) {
            return false;
        }

        position = position.moveOnePosition();
        return true;
    }
}
