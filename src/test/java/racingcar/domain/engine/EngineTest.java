package racingcar.domain.engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.generator.TestNumberGenerator;

class EngineTest {

    @ParameterizedTest
    @DisplayName("Engine 도메인의 run() 호출에 대해 전진 처리를 테스트 한다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void generate01(Integer value) {
        // given
        Engine engine = Engine.createBy(new TestNumberGenerator(value));

        // when
        MoveStatus moveStatus = engine.run();

        // then
        Assertions.assertEquals(MoveStatus.FORWARD, moveStatus);
    }

    @ParameterizedTest
    @DisplayName("Engine 도메인의 run() 호출에 대해 멈춤 처리를 테스트 한다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void generate02(Integer value) {
        // given
        Engine engine = Engine.createBy(new TestNumberGenerator(value));

        // when
        MoveStatus moveStatus = engine.run();

        // then
        Assertions.assertEquals(MoveStatus.STOP, moveStatus);
    }

}