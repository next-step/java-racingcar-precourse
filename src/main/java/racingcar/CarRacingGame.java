package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class CarRacingGame {

    public void play() {
        CarCollection carCollection = RetryableInputReader.read(InputType.CAR_NAME, CarCollection::new);
        int moveCount = RetryableInputReader.read(InputType.MOVE_COUNT, Integer::parseInt);

        Map<String, String> carTraceMap = this.moveCarAtRandom(moveCount, carCollection.getValues());

        int maxTraceSize = this.findMaxTraceSize(carTraceMap);
        this.printPlayResult(carTraceMap, maxTraceSize);
    }

    private Map<String, String> moveCarAtRandom(final int count, final String[] cars) {
        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < count; i++) {
            for (String key : cars) {
                result.put(key, this.appendRandomTrace(result.getOrDefault(key, "")));
            }
        }

        return result;
    }

    private String appendRandomTrace(final String target) {
        boolean isForwardMove = Randoms.pickNumberInRange(0, 9) > 3;
        return isForwardMove ? target + "-" : target;
    }

    private int findMaxTraceSize(final Map<String, String> source) {
        int maxTraceSize = 0;
        for (String integer : source.values()) {
            if (integer.length() > maxTraceSize) {
                maxTraceSize = integer.length();
            }
        }

        return maxTraceSize;
    }

    private void printPlayResult(final Map<String, String> carTraceMap, final int maxTraceSize) {
        System.out.println("실행 결과");
        for (String key : carTraceMap.keySet()) {
            System.out.printf("%s : %s%n", key, carTraceMap.getOrDefault(key, ""));
        }

        this.printFinalWinner(carTraceMap, maxTraceSize);
    }

    private void printFinalWinner(final Map<String, String> carTraceMap, final int maxTraceSize) {
        StringBuilder winner = new StringBuilder();
        for (String key : carTraceMap.keySet()) {
            if (carTraceMap.getOrDefault(key, "").length() != maxTraceSize) {
                continue;
            }

            final String DELIMITER = winner.length() > 0 ? ", " : "";
            winner.append(DELIMITER).append(key);
        }

        System.out.printf("최종 우승자: %s", winner);
    }

}