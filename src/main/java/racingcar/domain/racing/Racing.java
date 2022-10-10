package racingcar.domain.racing;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.racing.random.RacingRandom;
import racingcar.domain.racing.result.MoveResult;
import racingcar.domain.racing.result.Result;
import racingcar.domain.racing.result.WinnerResult;
import racingcar.domain.racing.validation.RacingValidator;

public class Racing {

    private int tryNo;
    private RacingValidator validators;
    private RacingRandom random;

    public Racing(String tryNo, RacingValidator validators, RacingRandom random) {
        this.random = random;
        this.validators = validators;
        validators.validate(tryNo);
        this.tryNo = Integer.parseInt(tryNo);
    }

    public Result result(List<Car> cars) {
        WinnerResult result = new WinnerResult(new MoveResult());
        List<List<Integer>> randoms = random.createRandoms(cars.size(), tryNo);
        for (List<Integer> random : randoms) {
            result.moveResult(cars, random);
        }
        result.winner(cars);
        return result;
    }
}
