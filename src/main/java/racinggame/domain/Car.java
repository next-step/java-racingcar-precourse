package racinggame.domain;

import nextstep.utils.Randoms;
import racinggame.utils.ValidationUtils;

public class Car {
    private static final int MIN_BOUND = 1;
    private static final int MAX_BOUND = 9;
    private static final int MOVING_FORWARD = 4;        // 4 이상 전진 / 3이하 정지

    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name == null || name.trim().equals(""))
            throw new IllegalArgumentException("자동차 이름이 빈값일 수 없습니다.");
        if (!ValidationUtils.validateCarNameLength(name))
            throw new IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다.");

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (getRandomNo() >= MOVING_FORWARD)
            this.position++;
    }

    protected int getRandomNo() {
        return Randoms.pickNumberInRange(MIN_BOUND, MAX_BOUND);
    }
}
