package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;
import racingcar.utils.RandomGenerator;

class RandomGeneratorTest {

    @RepeatedTest(10)
    public void 숫자는_0에서_9사이의_랜덤값이_생성된다() {
        // given & when
        int randomNumber = RandomGenerator.race();

        // then
        assertThat(randomNumber).isBetween(0, 9);
    }

}