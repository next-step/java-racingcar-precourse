package racingcar.model;

import racingcar.utils.RandomNumberMaker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 일급 컬렉션이면서, 리포지토리(모델 객체저장) 의 기능 수행
 */
public class CarRepository {
    public static CarRepository carRepository;
    private List<Car> cars;

    private CarRepository() {
        this.cars = new ArrayList<>();
    }

    public static CarRepository getInstance() {
        if (carRepository == null)
            carRepository = new CarRepository();
        return carRepository;
    }

    public CarRepository(List<Car> carCandidate) {
        cars = carCandidate;
    }

    public void addCar(Car newCar) {
        cars.add(newCar);
    }

    public int getSize() {
        return cars.size();
    }

    public void clear() {
        cars.clear();
    }

    /**
     * 매 턴마다 리포지토리에 저장되어있는 자동차들을 움직일지 말지 랜덤값을 통해 결정
     */
    public void startRound() {
        for (Car car : cars)
            car.moveOrNot(RandomNumberMaker.makeNumber());
    }

    public int getMaxDistance() {
        int result = 0;
        for (Car car : cars)
            result = Integer.max(result, car.getDistance());

        return result;
    }

    /**
     * 외부에서 리스트의 추가 제거를 막기 위해 이터레이터로 반환
     */
    public Iterator<Car> asIterator() {
        return cars.iterator();
    }
}
