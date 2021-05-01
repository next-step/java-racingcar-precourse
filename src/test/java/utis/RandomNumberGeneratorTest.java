package utis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {
    @DisplayName("0 부터 9까지의 랜덤한 숫자 생성 테스트")
    @Test
    void random_range_test() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int num = random.nextInt(10);
            assertThat(num).isBetween(0, 9);
        }
    }
}
