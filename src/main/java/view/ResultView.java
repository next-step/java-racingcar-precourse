package view;

import domain.Car;

import java.util.List;

public class ResultView {
    private final String RESULT_MESSAGE = "실행 결과";
    private final String WINNER_MESSAGE = "최종 우승자 : ";


    public void printResultMessage() {
        System.out.println("\n" + RESULT_MESSAGE);
    }

    public void printCars(List<Car> cars) {
        cars.forEach(System.out::println);
    }
}
