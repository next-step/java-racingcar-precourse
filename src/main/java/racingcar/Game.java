package racingcar;

import java.util.List;

public class Game {

    private int count = 0;
    List<RacingCar> racingCars;

    public Game(List<RacingCar> racingCars, int count) {
        this.racingCars = racingCars;
        this.count = count;
    }

    public void play() {

        System.out.println();
        System.out.println(GameMessage.PLAY_RESULT);

        for (int i = 0; i < count; i++) {
            run();
        }
        System.out.println(getVictoryCarNames());
    }

    private void run() {

        for (RacingCar racingCar : racingCars) {

            boolean forward = Rule.forward(Generator.randomNumber());
            forwardWhenTheRulesAreOkay(racingCar, forward);
        }
        System.out.println();
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

        System.out.println(sb.toString());
    }

    public String getVictoryCarNames() {
        return GameMessage.VICTORY_MESSAGE;
    }
}
