package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.RacingCarConstants.MAX_RANDOM_NUM;
import static racingcar.utils.RacingCarConstants.MIN_RANDOM_NUM;

public class RandomNumberGeneratorTest {
    @DisplayName("난수가 0~9 사이로 생성되는지 확인")
    @Test
    public void 난수_범위내로_생성_테스트() {
        //given
        //when
        int number1 = RandomNumberGenerator.generateNumber(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
        int number2 = RandomNumberGenerator.generateNumber(MIN_RANDOM_NUM, MAX_RANDOM_NUM);

        //then
        assertThat(number1).isBetween(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
        assertThat(number2).isBetween(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
    }
}
