package model;

import java.util.*;

/**
 * 게임 모델 클래스
 */
public class Game {

    private final Map<String, String> carPosition;

    /**
     * 게임 생성자
     *
     * @param carNames 자동차 이름 리스트
     */
    public Game(List<String> carNames) {
        carPosition = new HashMap<>();
        for (String carName : carNames) {
            carPosition.put(carName, "");
        }
    }

    /**
     * 자동차를 전진시키는 메서드
     *
     * @param carName 전진할 자동차
     */
    public void advance(String carName) {
        String currentPosition = carPosition.get(carName);
        carPosition.put(carName, currentPosition + "-");
    }

    /**
     * 레이싱 결과를 반환하는 메서드
     *
     * @return 레이싱 결과
     */
    public Map<String, String> getCarPosition() {
        return carPosition;
    }

    /**
     * 우승자를 반환하는 메서드
     *
     * @return 우승자 리스트
     */
    public List<String> getWinners() {

        int maxPosition = carPosition.values().stream()
            .mapToInt(String::length)
            .max()
            .orElse(0);

        List<String> winners = new ArrayList<>();

        for (String carName : carPosition.keySet()) {
            if (carPosition.get(carName).length() == maxPosition) {
                winners.add(carName);
            }
        }

        return winners;
    }
}
