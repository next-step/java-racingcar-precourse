package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.util.ValidationUtils;

public class RacingCars {
    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;

    private final List<RacingCar> racingCarList;

    public RacingCars() {
        racingCarList = new ArrayList<>();
    }

    public static RacingCars fromNames(String[] racingCarNames) {
        RacingCars racingCars = new RacingCars();

        for (String racingCarName: racingCarNames) {
            // 입력값 체크
            ValidationUtils.validName(racingCarName);
            racingCars.racingCarList.add(RacingCar.getFromName(racingCarName));
        }

        return racingCars;
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }

    public String getWinner() {
        StringBuilder winner = new StringBuilder();
        int longestDistance = 0;

        for (RacingCar racingCar : racingCarList) {
            longestDistance = Math.max(longestDistance, racingCar.getPosition());
        }

        for (RacingCar racingCar : racingCarList) {
            checkWinner(racingCar, winner, longestDistance);
        }

        return winner.substring(0, winner.length() - 2);
    }

    private void checkWinner(RacingCar racingCar, StringBuilder winner, int longestDistance) {
        if (racingCar.getPosition() == longestDistance) {
            winner.append(racingCar.getName()).append(", ");
        }
    }

    public void move() {
        for (RacingCar racingCar : racingCarList) {
            racingCar.move(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
        }
    }

}
