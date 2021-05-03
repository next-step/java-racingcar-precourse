package racingcar;

import java.util.List;

public class Game {

    private final GameCount gameCount;
    private final List<RacingCar> racingCars;
    private int maxForward = 0;

    public Game(List<RacingCar> racingCars, GameCount gameCount) {
        this.racingCars = racingCars;
        this.gameCount = gameCount;
    }

    public void play() {

        Print.write("");
        Print.write(GameMessage.PLAY_RESULT);

        for (int i = 0; i < gameCount.getNumber(); i++) {
            run();
        }
        Print.write(getVictoryMessage());
    }

    private void run() {

        for (RacingCar racingCar : racingCars) {

            boolean forward = Rule.forward(Generator.randomNumber());
            forwardWhenTheRulesAreOkay(racingCar, forward);
        }
        Print.write("");
    }

    private void forwardWhenTheRulesAreOkay(RacingCar racingCar, boolean forward) {
        if (forward) {
            racingCar.forward();
        }

        printResult(racingCar);
    }

    private void printResult(RacingCar racingCar) {

        String carName = racingCar.getName();
        int numberOfAdvances = racingCar.getNumberOfAdvances();

        StringBuilder sb = new StringBuilder();
        sb.append(carName);
        sb.append(":");
        for (int i = 0; i < numberOfAdvances; i++) {
            sb.append("-");
        }

        Print.write(sb.toString());
    }

    public String getVictoryMessage() {
        searchMaxForward();
        return searchVictoryRacingCar() + GameMessage.VICTORY_MESSAGE;
    }

    private String searchVictoryRacingCar() {
        return getVictoryRacingCarNames();
    }

    private String getVictoryRacingCarNames() {
        StringBuilder victoryCarNames = new StringBuilder();

        for (RacingCar racingCar : racingCars) {
            if (racingCar.getNumberOfAdvances() == this.maxForward) {
                victoryCarNames.append(racingCar.getName());
                victoryCarNames.append(",");
            }
        }

        victoryCarNames.deleteCharAt(victoryCarNames.length() - 1);

        return victoryCarNames.toString();
    }

    private void searchMaxForward() {
        for (RacingCar racingCar : racingCars) {
            if (this.maxForward < racingCar.getNumberOfAdvances()) {
                this.maxForward = racingCar.getNumberOfAdvances();
            }
        }
    }
}
