package racingcar.model.random.number.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public GeneratedRandomNumber generate() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return new GeneratedRandomNumber(randomNumber);
    }
}
