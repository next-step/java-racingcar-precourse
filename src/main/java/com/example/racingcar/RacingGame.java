package com.example.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {

    public RacingGame() {

    }

    public void Start() {
        Cars cars = inputCars();
        Turn turn = inputTurn();
        System.out.println("실행 결과");
        while (turn.next()) {
            cars.go();
            System.out.println(cars.getCurrentState());
        }
        Distance maxDistance = cars.getMaxDistance();
        Cars winner = cars.findCar(maxDistance);
        System.out.println(winner.getNames() + "가 최종 우승했습니다.");
    }

    private Cars inputCars() {
        String inputCarNames = inputCarNames();
        String[] carNames = inputCarNames.split(",");
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            Name carName = new Name(carNames[i]);
            Car car = new Car(carName);
            carList.add(car);
        }
        return new Cars(carList);
    }

    private String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) ");
        Scanner sc = new Scanner(System.in);
        String inputCarNames = sc.nextLine();
        return inputCarNames;
    }

    private Turn inputTurn() {
        System.out.println("시도할 회수는 몇회인가요? ");
        Scanner sc = new Scanner(System.in);
        String inputTurn = sc.nextLine();
        return new Turn(Integer.parseInt(inputTurn));
    }

}
