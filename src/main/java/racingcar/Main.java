package racingcar;

public class Main {
    public static void main(String[] args) {
        runRacingGame();
    }

    private static void runRacingGame() {
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                startRacingGame();
                isValidInput = true;
            } catch (IllegalStateException | IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
    }

    private static void startRacingGame() {
        String carNames = InputHandler.inputCarNames();
        int attempts = InputHandler.inputAttempts();
        RacingGame racingGame = new RacingGame(carNames, attempts);
        racingGame.start();
        OutputHandler.printRaceResult(racingGame);
    }

    private static void printErrorMessage(RuntimeException e) {
        System.out.println("[ERROR] " + e.getMessage());
    }
}