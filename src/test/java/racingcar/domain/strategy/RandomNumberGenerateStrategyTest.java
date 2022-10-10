package racingcar.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGenerateStrategyTest {

    @Test
    @DisplayName("0에서 9까지의 랜덤값을 생성한다.")
    void createRandomNumber() {
        //given
        NumberGenerateStrategy randomNumberGenerator = new RandomNumberGenerateStrategy();

        //when
        int randomNumber = randomNumberGenerator.generateNumber();

        //then
        assertThat(randomNumber).isBetween(0, 9);
    }
}
