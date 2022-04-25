package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.engine.Engine;
import racingcar.vo.racenumber.RaceNumber;

class CarTest {

    private static final int MOVABLE_MIN_NUMBER = 4;
    private static final int MOVABLE_DISTANCE = 1;
    private static final int INIT_DISTANCE = 0;

    @ParameterizedTest(name = "차에 문자열 이름을 부여 할 수 있다")
    @ValueSource(strings = {"a", "ab", "abc", " abcd", "abcde"})
    public void 문자열_이름_부여(String name) {
        assertThat(
                new Car(name, INIT_DISTANCE, new Engine(MOVABLE_MIN_NUMBER,
                        MOVABLE_DISTANCE)).getName()).isEqualTo(
                Name.from(name));
    }

    @ParameterizedTest(name = "이동 테스트")
    @ValueSource(ints = {4, 5, 6})
    public void 이동(int number) {
        Car car = new Car("Car", INIT_DISTANCE,
                new Engine(MOVABLE_MIN_NUMBER, MOVABLE_DISTANCE));
        car.move(RaceNumber.from(number));
        assertThat(car.getDistance()).isEqualTo(Distance.from(INIT_DISTANCE + MOVABLE_DISTANCE));
    }
}