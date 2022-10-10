package racingcar.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerateStrategy implements NumberGenerateStrategy{

    @Override
    public int generateNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
