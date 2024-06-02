public class RacingGameController {
    private final RacingGame racingGame = new RacingGame();

    public void run() {
        try {
            String carNamesInput = Input.getCarNames();
            racingGame.initializeCars(carNamesInput);

            run2();

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("[ERROR] " + e.getMessage());
            run();
        }

    }
    public void run2(){
        try {
            String roundsInput = Input.getRounds();
            racingGame.setRounds(roundsInput);

            racingGame.race();
            Output.printWinners(racingGame.getWinners());
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("[ERROR] " + e.getMessage());
            run2();
        }
    }

    public static void main(String[] args) {
        new RacingGameController().run();
    }
}