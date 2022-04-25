package racingcar;

public class GameController {

    private Circuit gameCircuit;
    private GameView gameView;

    public GameController(Circuit circuit, GameView view) {
        gameCircuit = circuit;
        gameView = view;
    }

    public void printCarNamesInputRequestMessage() {
        gameView.printCarNamesInputRequestMessage();
    }

    public void printLapCountInputRequestMessage() {
        gameView.printLapCountInputRequestMessage();
    }

    public void printLapResult() {
        gameView.printBlankLine();
        gameView.printLapResultBanner();

        for (int i = 0; i < gameCircuit.getLengthOfCarEntries(); i++) {
            RacingCar car = gameCircuit.getRacingCarAt(i);
            gameView.printCurrentResult(car);
            gameView.printBlankLine();
        }
    }

    public void printWinnerResult() {
        gameView.printWinnerBanner();
        CommaSeparatedCarNames winner_names = gameCircuit.getWinnerNames();
        gameView.printWinnerNames(winner_names);
    }

    public void printCloseMessage() {
        gameView.printCloseMessage();
    }

    public CommaSeparatedCarNames readCarNames() {
        return gameView.readCarNames();
    }

    public Laps readLapCount() {
        return gameView.readLapCount();
    }

    public void registerCarEntries(CommaSeparatedCarNames car_names) {
        gameCircuit.registerCarEntries(car_names);
    }

    public void registerLapsCount(Laps lap_count) {
        gameCircuit.registerLapsCount(lap_count);
    }

    public void takeALap() {
        gameCircuit.takeALap();
    }

    public boolean isFinished() {
        return gameCircuit.isFinished();
    }
}
