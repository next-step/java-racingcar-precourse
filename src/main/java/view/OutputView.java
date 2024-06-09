package view;

import model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String DASH = "-";
    private static final String RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : ";

    public static void printMoves(List<Car> cars) {
        cars.forEach(c -> System.out.println(c.getName() + " : " + makeStatus(c.getPosition())));
        System.out.println();
    }

    public static void printString() {
        System.out.println();
        System.out.println(RESULT);
    }

    private static String makeStatus(int position) {
        StringBuilder status = new StringBuilder();
        for(int i = 0 ; i < position; i++) {
            status.append(DASH);
        }
        return status.toString();
    }

    public static void printWinners(List<Car> cars) {
        String winners = cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(FINAL_WINNER + winners);
    }
}
