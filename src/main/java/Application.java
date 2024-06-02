import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputHandler.getCarNames();
        int rounds = InputHandler.getRounds();
        Race race = new Race(carNames, rounds);
        race.start();
        printRaceResult(race.getWinners());
    }

    private static void printRaceResult(List<Car> winners) {
        System.out.println("실행 결과");
        for (Car car : winners) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println("최종 우승자: " + getWinnerNames(winners));
    }

    private static String getWinnerNames(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        for (Car winner : winners) {
            sb.append(winner.getName()).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }
}