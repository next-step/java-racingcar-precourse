package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class RacingUtils {

    static void validationCarNames(String[] carNames) {
        Set<String> uniqueCarNames = new HashSet<>(Arrays.asList(carNames));
        if (carNames.length != uniqueCarNames.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 차 이름이 존재합니다.");
        }
    }

    static List<String> getWinners(List<Car> cars) {
        sortCarsOrderByPositionDescending(cars);

        List<String> winners = new ArrayList<>();
        Car winner = cars.get(0);

        for (Car candidate : cars) {
            winnerCheck(winners, winner, candidate);
        }

        return winners;
    }

    private static void winnerCheck(List<String> winners, Car winner, Car candidate) {
        if(CarUtils.hasEqualPosition(winner, candidate)) {
            winners.add(candidate.getCarName());
        }
    }

    private static void sortCarsOrderByPositionDescending(List<Car> cars) {
        cars.sort((car1, car2) -> car2.getCarPosition() - car1.getCarPosition());
    }
}
