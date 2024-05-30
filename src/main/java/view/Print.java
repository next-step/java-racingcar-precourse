package view;

import java.util.List;
import model.Car;

public class Print {
    public static void printCarNameInputComment() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printTryCountInputComment() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printCarMovement(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
    }

    public static void printTotalCarMovement(List<Car> cars) {
        cars.forEach(car -> printCarMovement(car));
        System.out.println();
    }

    public static void printExecutionResult() {
        System.out.println("실행 결과");
    }

    public static void printWinner(List<Car> winners) {
        System.out.println(
                "최종 우승자: " + String.join(", ", winners.stream().map(Car::getName).toList()));
    }
}
