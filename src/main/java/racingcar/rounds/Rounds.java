package racingcar.rounds;

import racingcar.cars.Cars;

import java.util.ArrayList;
import java.util.List;

public class Rounds {

    private static List<Round> rounds = new ArrayList<>();

    public Rounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public static Rounds playRacingCars(Cars cars, int currentRound) {
        rounds.add(new Round(cars.race(), currentRound));
        System.out.println();
        return new Rounds(rounds);
    }

    public static Round getLastRound() {
        return rounds.get(rounds.size() - 1);
    }
}
