package racingcar.racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.car.CarName;
import racingcar.car.CarNameValidator;
import racingcar.car.LengthCarNameValidator;

public class RacingCarNames {

    private final List<CarName> carNames;
    private final CarNameValidator validator;

    public RacingCarNames(List<String> carNames) {
        this(carNames, new LengthCarNameValidator(5));
    }

    public RacingCarNames(List<String> carNames, CarNameValidator carNameValidator) {
        this.carNames = new ArrayList<>();
        this.validator = carNameValidator;
        this.initCarNames(carNames);
    }

    private void initCarNames(List<String> carNames) {
        for (String carNameStr : carNames) {
            CarName carName = new CarName(carNameStr);
            validator.validCarName(carName);
            this.carNames.add(carName);
        }
    }

    public List<CarName> getCarNames() {
        return Collections.unmodifiableList(this.carNames);
    }

    public Integer carCount() {
        return this.carNames.size();
    }
}
