package racingcar;


import java.util.*;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicate(cars);
        this.cars = cars;
    }

    private void validateDuplicate(List<Car> cars) {
        Set<Car> duplicateCarSet = new HashSet<>(cars);
        if (duplicateCarSet.size() != cars.size()) {
            throw new IllegalArgumentException(Message.ERROR.message("자동차 이름이 중복되었습니다."));
        }
    }

    public void move() {
        for (Car car : cars) {
            car.move(RandomNumberUtil.getNumber());
        }
    }

    public Cars findWinners() {
        cars.sort(Comparator.reverseOrder());
        Car winner = cars.get(0);
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (winner.getPosition().equals(car.getPosition())) {
                winners.add(car);
            }
        }
        return new Cars(winners);
    }

    public String names() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Car car : cars) {
            stringBuffer.append(car.getName().toString());
            stringBuffer.append(", ");
        }
        return stringBuffer.toString().substring(0, stringBuffer.toString().length() - 2);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Car car : cars) {
            stringBuffer.append(car.toString());
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }
}

