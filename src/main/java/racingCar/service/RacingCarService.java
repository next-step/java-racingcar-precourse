package racingCar.service;

import racingCar.view.UI;

import java.util.*;

public class RacingCarService {

    private static final int GO = 4;

    public void doRacing(Map<String, Integer> carStats, int attempts, UI ui) {
        for (int i = 0; i < attempts; i++) {
            Iterator<String> keys = carStats.keySet().iterator();
            this.doRaceOneTurn(carStats, keys);
            ui.printCarStatus(carStats);
        }
    }

    private void doRaceOneTurn(Map<String, Integer> carStats, Iterator<String> iter) {
        while (iter.hasNext()) {
            String key = iter.next();
            if (isGo()) {
                carStats.put(key, carStats.get(key) + 1);
            }
        }
    }

    private boolean isGo() { // 앞으로 갈지 결정하는 메서드
        return Math.random() * 10 >= GO;
    }

    public String retWinner(Map<String, Integer> carStats) { // 승자를 String으로 반환하는 메서드
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(carStats.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue())); // entry의 value를 기준으로 sorting
        int maxValue = entryList.get(0).getValue(); // 최댓값 저장

        List<Map.Entry<String, Integer>> maxEntries = entryList.stream()
                .filter(entry -> entry.getValue().equals(maxValue))
                .toList(); // 최댓값과 같은 요소들만 필터링
        List<String> resultList = new ArrayList<>(maxEntries.size());
        for (Map.Entry<String, Integer> entry : maxEntries) {
            resultList.add(entry.getKey());
        }
        return String.join(", ", resultList);
    }
}
