package racingcar;

import java.util.List;

public class Game {

    private GameCount gameCount;
    private List<RacingCar> racingCars;

    public Game(List<RacingCar> racingCars, GameCount gameCount) {
        this.racingCars = racingCars;
        this.gameCount = gameCount;
    }

    public void play() {

        Print.write("");
        Print.write(GameMessage.PLAY_RESULT);

        for (int i = 0; i < gameCount.getGameCount(); i++) {
            run();
        }
        Print.write(getVictoryCarNames());
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

    public String getVictoryCarNames() {
        return GameMessage.VICTORY_MESSAGE;
    }
}
