package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하여야 한다.");
        }
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveRandomNumberStrategy() {
        move(() -> Randoms.pickNumberInRange(0, 9) > 3);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            position++;
        }
    }


}
