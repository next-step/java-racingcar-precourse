package me.ascii92der.racingcar;

import java.util.List;

public class OutputUI {

    private static final String RACE_RESULT = "실행 결과";

    public static void printRaceResult(Cars cars) {
        System.out.println(RACE_RESULT);
        for (Car car : cars.getCarGroup()) {
            System.out.println(car.getCarName() + " : " + getCurrentPositionOutput(car.getPosition()));
        }
        System.out.println();
    }

    public static String getCurrentPositionOutput(int position) {
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < position; index++) {
            result.append("-");
        }
        return result.toString();
    }

    public static void printWinner(List<String> winners) {
        System.out.println(String.join(",",winners)+"가 최종 우승했습니다");
    }
}
