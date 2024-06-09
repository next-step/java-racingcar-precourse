package camp.nextstep.edu.view;

import camp.nextstep.edu.domain.Car;

import java.util.List;
import java.util.stream.IntStream;

public class Output {

    public void printCurrentState(List<Car> cars) {
        cars.stream()
                .map(Car::currentStateMessage)
                .forEach(System.out::println);
        System.out.println();
    }

    public void printWinners(String[] winners) {
        System.out.print("최종 우승자 : ");
        IntStream.range(0, winners.length)
                .forEach(i -> {
                    System.out.print(winners[i]);
                    if (i < winners.length - 1) System.out.print(", ");
                });
    }
}
