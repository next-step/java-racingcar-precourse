package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class CarUtils {

    private static final int minimumConditionToMove = 4;
    private static final int minimumNumber = 0;
    private static final int maximumNumber = 9;

    static boolean isMovable(int number) {
        return judgeNumber(number);
    }

    static int pickNumber() {
        return Randoms.pickNumberInRange(minimumNumber, maximumNumber);
    }

    private static boolean judgeNumber(int number) {
        return number >= minimumConditionToMove;
    }

    static boolean hasEqualPosition(Car car1, Car car2) {
        return car1.getCarPosition() == car2.getCarPosition();
    }

    static void displayCarNameAndPath(Car car) {
        System.out.printf("%s : %s%n", car.getCarName(), car.getCarPath());
    }
}
