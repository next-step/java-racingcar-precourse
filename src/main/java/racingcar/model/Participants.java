package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Participants {

    private List<Car> cars;

    /**
     * Participants 객체 생성 함수
     */
    public Participants() {
        cars = new ArrayList<>();
    }

    /**
     * 참가 차량 리스트 조회 함수
     *
     * @return 조회된 차량 리스트
     */
    public List<Car> getCars() {
        return cars;
    }

    /**
     * 참가 차량 셋팅 함수
     *
     * @param cars 셋팅할 차량 리스트
     */
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    /**
     * 참가 차량 셋팅 함수
     *
     * @param carNames 셋팅할 차량 이름 리스트
     */
    public void setCarsByNames(List<String> carNames) {
        if (carNames.isEmpty()) {
            return;
        }
        List<Car> result = new ArrayList<>();
        for (String name : carNames) {
            result.add(new Car(name));
        }
        setCars(result);
    }

    /**
     * 게임 스테이지 진행 함수
     */
    public void progressStage() {
        cars.forEach(Car::randomlyMove);
    }

    /**
     * 1등 조회 함수
     *
     * @return 가장 빠른 차량들의 리스트
     */
    public List<String> getWinner() {
        Integer maxLocation = find1stLocation();
        return getCarNames(maxLocation);
    }

    /**
     * 특정 위치 차량 이름 조회 함수
     *
     * @param location 위치 값
     * @return 해당 위치에 있는 차량들의 이름 리스트
     */
    private List<String> getCarNames(Integer location) {
        List<String> result = new ArrayList<>();
        for (Car car : cars) {
            addNameIfCarOnLocation(result, car, location);
        }
        return result;
    }

    /**
     * 특정 위치 차량이 존재하면 리스트에 넣어주는 함수
     *
     * @param result   리스트
     * @param car      차량
     * @param location 기준 위치 값
     */
    private void addNameIfCarOnLocation(List<String> result, Car car, Integer location) {
        if (location.equals(car.getLocation())) {
            result.add(car.getName());
        }
    }

    /**
     * 차량 중 1등의 위치 값 조회 함수
     *
     * @return 1등의 위치 값
     */
    private Integer find1stLocation() {
        int max = Integer.MIN_VALUE;
        for (Car car : cars) {
            max = Integer.max(max, car.getLocation());
        }
        return max;
    }
}
