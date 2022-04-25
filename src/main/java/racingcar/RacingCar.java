package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar implements Comparable<RacingCar> {
    private final CarName name;
    private final Distance distance;
    private final RandomUtil randomUtil;

    public RacingCar(CarName car_name) {
        randomUtil = new NextstepRandomUtil();
        name = new CarName(car_name.toString());
        distance = new Distance();
    }

    public RacingCar(CarName car_name, RandomUtil util) {
        randomUtil = util;
        name = new CarName(car_name.toString());
        distance = new Distance();
    }

    public CarName getCarName() {
        return name;
    }

    public Distance getDistance() {
        return distance;
    }

    public void move() {
        distance.increase();
    }

    public void moveOrStop() {
        if (canMove()) {
            move();
        }
    }

    private boolean canMove() {
        int randomValue = randomUtil.getNumberInRange(0, 9);

        return randomValue > 3;
    }

    @Override
    public int compareTo(RacingCar other) {
        return distance.compareTo(other.getDistance());
    }

    public interface RandomUtil {
        int getNumberInRange(final int startInclusive, final int endInclusive);
    }

    public static class NextstepRandomUtil implements RandomUtil {

        @Override
        public int getNumberInRange(final int startInclusive, final int endInclusive) {
            return Randoms.pickNumberInRange(startInclusive, endInclusive);
        }
    }

}
