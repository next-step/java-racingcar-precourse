package view;

import model.Car;

import java.util.List;

public class ResultView {
    public void printRaceStatus(List<Car> cars) {
        cars.forEach(System.out::println);
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
