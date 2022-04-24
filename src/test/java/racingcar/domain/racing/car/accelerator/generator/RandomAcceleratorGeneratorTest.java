package racingcar.domain.racing.car.accelerator.generator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomAcceleratorGeneratorTest {
    @Test
    @DisplayName("임의의 파워로 가속장치를 생성한다")
    void 임의의_파워로_가속장치를_생성한다() {
        AcceleratorGenerator acceleratorGenerator = RandomAcceleratorGenerator.create();
        assertThat(acceleratorGenerator.generate()).isNotNull();
    }
}
