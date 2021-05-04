package com.example.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
    public RacingGame() {

    }

    public void Start() {

    }

    private Cars inputCars() {
        String inputCarNames = inputCarNames();
        String[] carNames = inputCarNames.split(",");
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            Name carName = new Name(name);
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
