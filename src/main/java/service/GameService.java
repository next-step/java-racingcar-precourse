package service;

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

}
