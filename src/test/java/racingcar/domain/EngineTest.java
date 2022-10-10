package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class EngineTest {

    private Engine engine;

    @BeforeEach
    void setUp() {
        engine = new Engine();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("4~9 사이의 값을 입력받으면 Engine은 FORWARD를 반환홤")
    void test2(Integer accel) {
        AccelValue value = AccelValue.of(accel);

        assertThat(engine.accel(value)).isEqualTo(Move.FORWARD);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("0~3 사이의 값을 입력받으면 Engine은 STOP을 반환홤")
    void test1(Integer accel) {
        AccelValue value = AccelValue.of(accel);

        assertThat(engine.accel(value)).isEqualTo(Move.STOP);
    }
}