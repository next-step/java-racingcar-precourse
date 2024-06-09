package controller;

import model.Car;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CarRaceController {
    public void startRace() {
        try {
            List<String> carNames = InputView.getCarNames();
            int raceCount = InputView.getRaceCount();

            List<Car> cars = createAndInitializeCars(carNames);
            runRace(cars, raceCount);
            List<Car> winners = determineWinners(cars); // 우승자 결정
            // TODO: 우승자 출력 로직 추가
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

    private void runRace(List<Car> cars, int raceCount) {
        Random random = new Random();
        for (int i = 0; i < raceCount; i++) {
            for (Car car : cars) {
                if (random.nextInt(10) >= 4) { // 4 이상이면 전진
                    car.move();
                }
            }
            printRaceStatus(cars); // 각 회차 결과 출력
        }
    }

    private void printRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            StringBuilder status = new StringBuilder();
            status.append(car.getName()).append(" : ");
            for (int i = 0; i < car.getPosition(); i++) {
                status.append("-");
            }
            OutputView.printMessage(status.toString());
        }
        OutputView.printMessage(""); // 빈 줄로 회차 구분
    }

    private List<Car> determineWinners(List<Car> cars) {
        int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0); // 최대 거리 계산

        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .collect(Collectors.toList());
    }
}
