package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars = new ArrayList<>();
    private final int tryCount;
    private final ResultView resultView;

    public Race(String[] carNames, int tryCount, ResultView resultView) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        if (tryCount <= 0) {
            throw new IllegalArgumentException("이동 횟수는 1 이상이어야 합니다.");
        }
        this.tryCount = tryCount;
        this.resultView = resultView;
    }

    public void start() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                int randomNumber = RandomNumberGenerator.generate();
                car.move(randomNumber);
            }
            resultView.printRoundResult(this); // 각 시도 후 결과 출력
        }
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }
}
