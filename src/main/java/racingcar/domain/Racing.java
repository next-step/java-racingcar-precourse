package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private List<RacingCar> racingCars;
    private Move move;

    public Racing(String carNames) {
        this.racingCars = Arrays.stream(carNames.split(Code.DELIMITER)).map(name -> new RacingCar(name)).collect(Collectors.toList());
        this.move = new Move();
    }

    public void race() {
        for (RacingCar car : racingCars) {
            car.racing(Randoms.pickNumberInRange(0, 9), move);
        }
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }
}
