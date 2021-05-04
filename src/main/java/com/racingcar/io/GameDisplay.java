package com.racingcar.io;

import com.racingcar.domain.Car;
import com.racingcar.domain.CarName;
import com.racingcar.domain.CarPosition;
import com.racingcar.domain.Cars;
import com.racingcar.domain.TryCount;
import com.racingcar.domain.Winner;
import com.racingcar.domain.Winners;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameDisplay {

    private static final Integer CAR_INITIAL_POSITION = 0;
    private static final String SPLIT_TOKEN_COMMA = ",";
    private static final String DIVIDE_TOKEN = ":";
    private static final String INPUT_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String WINNER_LIST_MESSAGE = "가 최종 우숭했습니다.";

    public static Scanner scanner = new Scanner(System.in);

    public static Cars inputCars() {
        System.out.println(INPUT_CARS_MESSAGE);

        String line = scanner.nextLine();
        String[] splitted = line.split(SPLIT_TOKEN_COMMA);

        List<Car> cars = new ArrayList<>();
        for (String split : splitted) {
            cars.add(Car.of(CarPosition.of(CAR_INITIAL_POSITION), CarName.of(split)));
        }

        return Cars.of(cars);
    }

    public static TryCount inputTryCount() {
        System.out.println(INPUT_TRY_MESSAGE);
        int count = scanner.nextInt();
        return TryCount.of(count);
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printCarResult(Cars cars) {
        for (Car car : cars) {
            System.out.println(car + DIVIDE_TOKEN + car.makeCarPosition());
        }
        System.out.println();
    }

    public static void printWinners(Winners winners) {
        StringBuilder result = new StringBuilder();

        int lastIndex = winners.length();
        int currentIndex = 1;

        for (Winner winner : winners) {
            result.append(winner);
            postfixSplitter(result, lastIndex, currentIndex++);
        }

        System.out.println(result + WINNER_LIST_MESSAGE);
    }

    private static void postfixSplitter(StringBuilder target, int lastIndex, int currentIndex) {
        if (currentIndex != lastIndex) {
            target.append(SPLIT_TOKEN_COMMA);
        }
    }
}
