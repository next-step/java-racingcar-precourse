package racingcar.dto;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private Integer moved;

    private final String name;

    public RacingCar(String name) {
        this.moved = 0;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Integer getMoved() {
        return this.moved;
    }

    public void move() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            this.moved++;
        }
    }
}
