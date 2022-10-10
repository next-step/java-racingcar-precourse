package racingcar.domain.racing.random;

import java.util.List;

public interface RacingRandom {

    int START_INCLUSIVE = 0;
    int END_INCLUSIVE = 9;

    List<List<Integer>> createRandoms(int carsNo, int tryNo);
}
