package racingcar.application;

import java.util.Arrays;
import java.util.List;
import racingcar.application.port.RacingCarResultResponse;
import racingcar.application.port.in.RacingCarPlayUseCase;
import racingcar.domain.Activity;
import racingcar.domain.Car;
import racingcar.domain.ForwardRule;
import racingcar.domain.Name;
import racingcar.domain.PickNumberRule;
import racingcar.domain.RacingCar;
import racingcar.domain.WinnerRule;

public class RacingCarService implements RacingCarPlayUseCase {
    private final PickNumberRule pickNumberRule;
    private final ForwardRule forwardRule;
    private final WinnerRule winnerRule;

    public RacingCarService(
            final PickNumberRule pickNumberRule,
            final ForwardRule forwardRule,
            final WinnerRule winnerRule
    ) {
        this.pickNumberRule = pickNumberRule;
        this.forwardRule = forwardRule;
        this.winnerRule = winnerRule;
    }

    @Override
    public RacingCarResultResponse play(final int number, final String... names) {
        RacingCar racingCar = createDefaultRacingCar(names);
        racingCar.play(number);
        return createRacingCarResultResponse(racingCar);
    }

    private RacingCar createDefaultRacingCar(final String[] names) {
        return new RacingCar(
                this.pickNumberRule,
                this.forwardRule,
                this.winnerRule,
                Arrays.stream(names).map(Name::new).toArray(Name[]::new)
        );
    }

    private RacingCarResultResponse createRacingCarResultResponse(final RacingCar racingCar) {
        List<Activity> activities = racingCar.activities();
        List<Car> winners = racingCar.winner().value();
        return new RacingCarResultResponse(activities, winners);
    }
}
