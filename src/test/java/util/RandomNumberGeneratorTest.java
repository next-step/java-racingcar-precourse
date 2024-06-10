package util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @DisplayName("0부터 9까지 무작위 수를 생성한다.")
    @Test
    void generateRandomNumber() throws Exception {
        //given
        RandomNumberGenerator generator = new RandomNumberGenerator();

        //when
        int randomNumber = generator.generateRandomNumber();

        //then
        assertThat(randomNumber).isBetween(0, 9);
    }

}
