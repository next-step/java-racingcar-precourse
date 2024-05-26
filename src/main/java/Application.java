import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        try {
            String[] carNames = InputView.getCarNames();
            int attempts = InputView.getAttempts();

            Race race = new Race(Arrays.asList(carNames), attempts);
            race.start();

            System.out.println("실행 결과");
            ResultView.printRaceResult(race.getCars());
            ResultView.printWinners(race.getWinners());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
