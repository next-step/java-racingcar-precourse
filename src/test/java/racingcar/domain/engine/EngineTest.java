package racingcar.domain.engine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.car.Distance;
import racingcar.vo.racenumber.RaceNumber;

class EngineTest {
    Engine engine;
    private static final int MOVABLE_MIN_NUMBER = 4;
    private static final int MOVABLE_DISTANCE = 1;
    private static final int NOT_MOVE_DISTANCE = 0;


    @BeforeEach
    public void before() {
        engine = new Engine(MOVABLE_MIN_NUMBER, MOVABLE_DISTANCE);
    }

    @ParameterizedTest(name = "4 이상, 9이하의 숫자일 경우 앞으로 1씩 움직인다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 앞으로_움직임(int number) {

        assertThat(engine.goForward(RaceNumber.from(number))).isEqualTo(Distance.from(MOVABLE_DISTANCE));
    }

    @ParameterizedTest(name = "3 이하의 숫자일 경우 앞으로 움직이지 않는다.")
    @ValueSource(ints = {0, 1, 2, 3})
    public void 움직이지_않음(int number) {

        assertThat(engine.goForward(RaceNumber.from(number))).isEqualTo(Distance.from(NOT_MOVE_DISTANCE));
    }
}