public class RacingGameController {
    private final RacingGame racingGame = new RacingGame();

    public void run() {
        try {
            String carNamesInput = Input.getCarNames();
            racingGame.initializeCars(carNamesInput);

            String roundsInput = Input.getRounds();
            racingGame.setRounds(roundsInput);

            racingGame.race();
            Output.printRaceStatus(racingGame.getCars());
            Output.printWinners(racingGame.getWinners());
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("[ERROR] " + e.getMessage());
            run();
        }
    }

    public static void main(String[] args) {
        new RacingGameController().run();
    }
}