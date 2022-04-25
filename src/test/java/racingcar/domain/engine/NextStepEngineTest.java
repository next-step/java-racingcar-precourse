package racingcar.domain.engine;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.generator.NextStepFuelGenerator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static racingcar.Assertions.assertRandomTest;

class NextStepEngineTest {

    @Test
    @DisplayName("NextStepEngine에 정차에 해당되는 값이 설정된 후, gearShift 시도 시 false를 반환하는지 확인한다.")
    void 지정값_멈춤_확인() {
        NextStepEngine engine = new NextStepEngine(new NextStepFuelGenerator());
        boolean result = engine.gearShift(2);
        assertFalse(result, "gearShift는 false를 반환해야 합니다.");
    }

    @Test
    @DisplayName("NextStepEngine에 정차에 해당되는 값이 설정된 후, gearShift 시도 시 true를 반환하는지 확인한다.")
    void 지정값_전진_확인() {
        NextStepEngine engine = new NextStepEngine(new NextStepFuelGenerator());
        boolean result = engine.gearShift(7);
        assertTrue(result, "gearShift는 true를 반환해야 합니다.");
    }

    @Test
    @DisplayName("NextStepEngine에 정차에 해당되는 값이 설정된 후, move 시도 시 false를 반환하는지 확인한다.")
    void 랜덤값_멈춤_확인() {
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () -> {
                    NextStepEngine engine = new NextStepEngine(new NextStepFuelGenerator());
                    boolean result = engine.move();
                    assertFalse(result, "move는 false를 반환해야 합니다.");
                },
                1
        );
    }

    @Test
    @DisplayName("NextStepEngine에 전진에 해당되는 값이 설정된 후, move 시도 시 true를 반환하는지 확인한다.")
    void 랜덤값_전진_확인() {
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () -> {
                    NextStepEngine engine = new NextStepEngine(new NextStepFuelGenerator());
                    boolean result = engine.move();
                    assertTrue(result, "move는 true를 반환해야 합니다.");
                },
                5
        );
    }

    @Test
    @DisplayName("NextStepEngine에 범위 이하의 값이 설정된 후, move 시도 시 에러를 발생시키는지 확인한다.")
    void 범위이하값_에러_확인(){
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () -> assertThatThrownBy(
                        () -> {
                            NextStepEngine engine = new NextStepEngine(new NextStepFuelGenerator());
                            engine.move();
                        }
                ) .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("랜덤 값의 범위를 벗어났습니다."),
                -1
        );
    }

    @Test
    @DisplayName("NextStepEngine에 범위 이상의 값이 설정된 후, move 시도 시 에러를 발생시키는지 확인한다.")
    void 범위이상값_에러_확인(){
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () -> assertThatThrownBy(
                        () -> {
                            NextStepEngine engine = new NextStepEngine(new NextStepFuelGenerator());
                            engine.move();
                        }
                ) .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("랜덤 값의 범위를 벗어났습니다."),
                10
        );
    }

}