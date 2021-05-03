package racing.model;

import racing.model.strategy.RandomMoving;

import java.util.*;

public class Cars {

    private final List<Car> list;
    private static String WINNER_LIST_DELIMITER = ", ";

    public Cars(List<String> carNames) {
        list = new ArrayList<>();
        carNames.forEach(carName -> list.add(new Car(carName)));
    }

    public List<Car> getList() {
        return list;
    }

    /**
     * 레이스(경주)
     *
     * @param randomMoving
     */
    public void race(RandomMoving randomMoving) {
        list.forEach(car -> car.move(randomMoving));
    }

    /**
     * 우승자 목록
     *
     * @return
     */
    public String getWinners() {
        int topRecord = getTopRecord();
        StringJoiner stringJoiner = new StringJoiner(WINNER_LIST_DELIMITER);

        for (Car car : list) {
            stringJoiner = getWinnerName(car, topRecord, stringJoiner);
        }

        return stringJoiner.toString();
    }

    /**
     * 최고성적 찾기
     *
     * @return
     */
    private int getTopRecord() {
        Car topRecordCar = Collections.max(list, Comparator.comparing(compare -> compare.getRecordResult()));
        return topRecordCar.getRecordResult();
    }

    /**
     * 우승자이름 반환
     *
     * @param car
     * @param topRecord
     * @param stringJoiner
     * @return
     */
    private StringJoiner getWinnerName(Car car, int topRecord, StringJoiner stringJoiner) {
        if (car.getRecordResult() == topRecord) {
            stringJoiner.add(car.getName());
        }

        return stringJoiner;
    }

}
