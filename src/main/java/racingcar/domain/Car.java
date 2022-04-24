package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.common.GameConfig;

public class Car implements Comparable<Car> {
    private Name name;
    private Position position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Name getName() {
        return this.name;
    }

    public Position getPosition() {
        return this.position;
    }

    public void move() {
        int no = generateRandomNo(GameConfig.MIN_RANDOM_NO, GameConfig.MAX_RANDOM_NO);
        if (isGo(no)) {
            position.increasePosition();
        }
    }

    public boolean isGo(int no) {
        return no >= GameConfig.MOVE_CONDITION_NO;
    }

    public int generateRandomNo(int startNo, int endNo) {
        return Randoms.pickNumberInRange(startNo, endNo);
    }

    @Override
    public int compareTo(Car car) {
        return position.isFrontPosition(car.getPosition()) ? 1 : -1;
    }
}
