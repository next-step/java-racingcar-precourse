package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class RacingCar {
    private static final Position RACING_CAR_DEFAULT_POSITION = new Position(0);

    private Cars cars;
    private final List<Activity> activities;
    private final PickNumberRule pickNumberRule;
    private final ForwardRule forwardRule;
    private final WinnerRule winnerRule;

    public RacingCar(
            final PickNumberRule pickNumberRule,
            final ForwardRule forwardRule,
            final WinnerRule winnerRule,
            final Name... names
    ) {
        Car[] carArray = Arrays.stream(names)
                .map(name -> new Car(name, RACING_CAR_DEFAULT_POSITION))
                .toArray(Car[]::new);

        this.cars = new Cars(carArray);
        this.activities = new ArrayList<>();
        this.pickNumberRule = pickNumberRule;
        this.forwardRule = forwardRule;
        this.winnerRule = winnerRule;
    }

    public void play(final int number) {
        IntStream.range(0, number)
                .forEach(i -> {
                    this.cars = this.cars.forward(this.forwardRule, pickNumberRule);
                    this.activities.add(this.cars.activity());
                });
    }

    public Cars winner() {
        return winnerRule.winner(this.cars);
    }
}
