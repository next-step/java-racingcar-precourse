package racingcar.game;

import racingcar.car.Car;
import racingcar.car.CarStatus;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class PlayResult {

    private static final int ZERO = 0;
    private static final int PLUS = 1;
    private static final String EXPRESSION_STR = "-";

    private final Map<Car, Integer> playResult = new HashMap<>();

    public void report(Car car, CarStatus status) {
        if(status.isNext()) {
            updateResult(car);
            return;
        }
        createResult(car);
    }

    private void updateResult(Car car) {
        if(playResult.containsKey(car)) {
            playResult.replace(car, playResult.get(car) + PLUS);
            return;
        }
        playResult.put(car, PLUS);
    }

    private void createResult(Car car) {
        if(!playResult.containsKey(car)) {
            playResult.put(car, ZERO);
        }
    }

    public void printPlayResult() {
        for(Map.Entry<Car, Integer> entry : playResult.entrySet()) {
            System.out.println(
                    entry.getKey().getName() + " : " +
                    String.join("", Collections.nCopies(entry.getValue(), EXPRESSION_STR))
            );
        }
    }

    public void printWinners() {
        List<String> winners = getWinners();
        String strWinners = String.join(",", winners);
        System.out.println("최종 우승자 : " + strWinners);
    }

    private List<String> getWinners() {
        Integer maxNum = Collections.max(playResult.values());
        return playResult.entrySet().stream()
                .filter(entry -> entry.getValue().equals(maxNum))
                .map(Map.Entry::getKey)
                .map(Car::getName)
                .collect(toList());
    }
}
