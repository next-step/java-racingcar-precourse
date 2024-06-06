package service;

import java.util.ArrayList;
import java.util.List;
import model.Car;

public class GameService {

    /**
     * 자동차들을 전진시키는 메서드
     *
     * @param cars 게임에 참여하는 자동차들
     */
    public void moveCars(List<Car> cars) {
        for(Car car : cars) {
            car.move();
        }
    }

    /**
     * 참여하는 자동차들 중 우승자(가장 position 값이 큰)를 찾는 메서드
     *
     * @param cars 게임에 참여하는 자동차 리스트
     * @return winners 가장 position 값이 큰 우승자들
     */
    public List<Car> findWinners(List<Car> cars) {
        int winnerPosition = findMaxPosition(cars);
        List<Car> winners = new ArrayList<>();
        for(Car car : cars) {
            if(car.getPosition() == winnerPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    /**
     * 자동차의 position 값 중 최대값을 찾는 메서드
     *
     * @param cars 게임에 참여하는 자동차 리스트
     * @return maxPosition position값의 최대값
     */
    private int findMaxPosition(List<Car> cars) {
        int max = -1;
        for(Car car : cars) {
            if(max < car.getPosition()) {
                max = car.getPosition();
            }
        }
        return max;
    }

}
