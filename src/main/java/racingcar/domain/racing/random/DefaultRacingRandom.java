package racingcar.domain.racing.random;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class DefaultRacingRandom implements RacingRandom {
    @Override
    public List<List<Integer>> createRandoms(int carsNo, int tryNo) {
        List<List<Integer>> randoms = new ArrayList<>();
        for (int i = 0; i < tryNo; i++) {
            randoms.add(createRandom(carsNo));
        }
        return randoms;
    }

    private List<Integer> createRandom(int carsNo) {
        List<Integer> random = new ArrayList<>();
        for (int i = 0; i < carsNo; i++) {
            random.add(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
        }
        return random;
    }
}
