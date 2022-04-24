package racingcar.domain.racing.car.accelerator.generator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ManualAcceleratorGeneratorTest {
    @Test
    @DisplayName("입력된 파워로 가속장치를 생성한다")
    void 입력된_파워로_가속장치를_생성한다() {
        AcceleratorGenerator acceleratorGenerator = ManualAcceleratorGenerator.from(3);
        assertThat(acceleratorGenerator.generate()).isNotNull();
    }
}
