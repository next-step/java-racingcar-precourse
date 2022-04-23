package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.NameParse;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private static final int DEFAULT_POSITION = 0;

    private final List<RacingCar> racingCarList;

    public RacingCars(List<RacingCar> racingCarList) {
        this.racingCarList = racingCarList;
    }

    public static RacingCars from(String carName) {
        List<RacingCar> carList = new ArrayList<>();
        String[] carNames = NameParse.parseName(carName);
        for (String name : carNames) {
            carList.add(new RacingCar(name));
        }

        return new RacingCars(carList);
    }

    public void playByRound(int round) {
        for (int playRound = 0; playRound < round; playRound++) {
            play();
        }
    }

    private void play() {
        for (RacingCar racingCar : this.racingCarList) {
            racingCar.move(new RandomMovingStrategy());
        }
    }

    public List<RacingCar> getRacingCarList() {
        return this.racingCarList;
    }

    public List<String> findWinners() {
        int winnerPosition = findWinnerPosition();
        return findCarNamesByPosition(winnerPosition);
    }

    private List<String> findCarNamesByPosition(int winnerPosition) {
        List<String> carNameList = new ArrayList<>();
        for (RacingCar racingCar : this.racingCarList) {
            racingCar.findCarNameByPosition(carNameList, winnerPosition);
        }
        return carNameList;
    }

    private int findWinnerPosition() {
        int maxPosition = DEFAULT_POSITION;
        for (RacingCar racingCar : this.racingCarList) {
            maxPosition = racingCar.equalsAndReturnBigNumber(maxPosition);
        }
        return maxPosition;
    }
}
