import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        try {
            String[] carNames = InputView.getCarNames();
            int attempts = InputView.getAttempts();

            Race race = new Race(Arrays.asList(carNames), attempts);

            System.out.println("\n실행 결과");
            race.start();
            ResultView.printWinners(race.getWinners());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
