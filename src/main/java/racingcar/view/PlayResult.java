package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class PlayResult {

    public static void getProcessPrint(Car car) {
        System.out.println(car.getName() + " : " + car.getProgress());
    }

    public static void getResultPrint(List<String> result) {
        System.out.println("최종 우승자: " + String.join(",", result));
    }
}
