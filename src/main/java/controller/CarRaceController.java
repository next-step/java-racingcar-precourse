package controller;

import model.Car;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class CarRaceController {
    public void startRace() {
        try {
            List<String> carNames = InputView.getCarNames();
            int raceCount = InputView.getRaceCount();

            List<Car> cars = createAndInitializeCars(carNames);
            // TODO: 경주 시작 로직 추가
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
    }

    private List<Car> createAndInitializeCars(List<String> carNames) {
        return carNames.stream()
            .map(name -> {
                Car car = new Car(name);
                car.initializePosition(); // 위치 초기화
                return car;
            })
            .collect(Collectors.toList());
    }
}
