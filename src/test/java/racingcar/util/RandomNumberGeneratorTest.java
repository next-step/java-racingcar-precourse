package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.util.RandomNumberGenerator.generateRandomNumber;

public class RandomNumberGeneratorTest {
    @Test
    @DisplayName(value="랜덤값 생성 범위 테스트")
    public void randomNumberGeneratorValidationTest(){
        assertThat(generateRandomNumber()).isBetween(0,9);
    }
}
