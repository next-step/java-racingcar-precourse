import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomGeneratorTest {
    private RandomGenerator randomGenerator;

    @BeforeEach
    void setup() {
        randomGenerator = new RandomGenerator();
    }

    @Test
    @DisplayName("랜덤으로 생성된 값은 0~9 사이의 값을 가져야 한다.")
    void generate_between_0_9() {
        Assertions.assertThat(randomGenerator.get()).isGreaterThanOrEqualTo(0);
        Assertions.assertThat(randomGenerator.get()).isLessThanOrEqualTo(9);
    }

    @Test
    @DisplayName("랜덤으로 생성된 값은 무조건 양수이어야 한다.")
    void generate_negative_value_must_be_failed() {
        Assertions.assertThat(randomGenerator.get()).isNotNegative();
    }

    @Test
    @DisplayName("1000번 연속으로 생성된 랜덤 값들 중 적어도 하나는 첫 번째 랜덤 값과 다른 값이어야 한다.")
    void generate_random_values_100_times() {
        List<Integer> randoms = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            randoms.add(randomGenerator.get());
        }

        Assertions.assertThat(randoms).filteredOn(r -> r != randoms.get(0)).hasSizeGreaterThan(0);
    }
}
