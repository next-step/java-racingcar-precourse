package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public static void printOutput(){
        System.out.println("\n실행 결과");
    }
    public static void printRace(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
