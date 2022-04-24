package racingcar.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RacingGame {

    private final Lineup lineup;

    public RacingGame(String... carNames) {
        lineup = makeLineup(carNames);
    }

    private Lineup makeLineup(String... carNames) {
        assertDuplicateNames(carNames);
        Lineup lineup = new Lineup();
        for (String name : carNames) {
            lineup.addCar(new Car(name));
        }

        return lineup;
    }

    public Lineup getLineup() {
        return lineup;
    }

    private void assertDuplicateNames(String... names) {
        Set<String> nameSet = new HashSet<>(Arrays.asList(names));
        if (nameSet.size() < names.length) {
            throw new IllegalArgumentException();
        }
    }

    public RacingReport race() {
        MovingConditions conditions = ConditionGenerator.generate(lineup);
        return lineup.race(conditions);
    }
}
