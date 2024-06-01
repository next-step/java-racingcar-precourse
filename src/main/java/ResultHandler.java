import java.util.List;
import java.util.stream.Collectors;

public class ResultHandler {
    public static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}