package view;

import java.util.List;
import java.util.stream.Collectors;
import model.Car;

public class OutputView {

    public void printResult() {
        System.out.println("\n실행 결과");
    }

    public void printRoundOutput(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getStep(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        System.out.println("최종 우승자 : " + winners.stream()
                                                .map(Car::getName)
                                                .collect(Collectors.joining(", ")));
    }
}
