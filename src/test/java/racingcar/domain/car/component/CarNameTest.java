package racingcar.domain.car.component;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.name.NextStepValidatorName;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {

    @Test
    @DisplayName("CarName가 설정된 이름을 정상적으로 반환하는지 확인한다.")
    void 이름_정상_반환_테스트() {
        CarName carName = new CarName("test", new NextStepValidatorName());
        assertEquals(carName.getName(), "test", "'test'를 정상적으로 반환해야 합니다");
    }

    @Test
    @DisplayName("CarName에 비정상적인 이름 설정 시 에러를 발생시키는지 확인한다.")
    void 이름_정상_검증_테스트() {
        assertThatThrownBy(
                () -> {
                    CarName carName = new CarName("testtest", new NextStepValidatorName());
                }
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름의 길이가 잘못되었습니다.");

    }
}