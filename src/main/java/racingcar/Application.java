package racingcar;

public class Application {
    public static void main(String[] args) {
        Cars cars = getCars();
        int attempt = getNumberOfAttempts();

        while (attempt-- > 0) {
            cars.race();
            OutputView.printResult(cars);
        }
        OutputView.printWinners(cars);
    }

    private static int getNumberOfAttempts() {
        while (true) {
            try {
                return InputView.typeNumberOfAttempts();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Cars getCars() {
        while (true) {
            try {
                String[] carNames = InputView.typeCarNames();
                return new Cars(carNames);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
