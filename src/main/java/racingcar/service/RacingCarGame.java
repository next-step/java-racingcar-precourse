package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.CarMovingUtils;
import racingcar.view.OutputView;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingCarGame {

    private static Map<String, Integer> carMovingSumNums;
    private static String winner;

    public RacingCarGame(List<String> carNames, int roundNum) {
        initRacingCarGame(carNames);
        OutputView.printRunResultMessage();

        for (int i = 0; i < roundNum; i++) {
            roundRacingCar(carNames);
        }

        OutputView.printWinner(getMaxMovingCarName(carMovingSumNums));
    }

    private void initRacingCarGame(List<String> carNames) {
        carMovingSumNums = new HashMap<>();
        for (String carName : carNames) {
            carMovingSumNums.put(carName, 0);
        }
    }

    private void roundRacingCar(List<String> carNames) {

        for (String carName : carNames) {
            int randomMovingNum = getRandomMovingNum();
            OutputView.printCarRacing(carName, randomMovingNum);

            sumCarMoving(carName, randomMovingNum);
        }

        System.out.println();
    }

    private void sumCarMoving(String carName, int randomMovingNum) {
        if(CarMovingUtils.isGo(randomMovingNum)){
            Integer currentMovingNum = carMovingSumNums.get(carName);
            carMovingSumNums.put(carName, ++currentMovingNum);
        }
    }

    private int getRandomMovingNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static String getMaxMovingCarName(Map<String, Integer> carMovingSumNums) {

        Integer maxMovingNum = Collections.max(carMovingSumNums.values());

        winner = carMovingSumNums.entrySet()
                .stream()
                .filter(car -> car.getValue().equals(maxMovingNum))
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", "));

        return winner;
    }

    public static String getWinner() {
        return winner;
    }
}
