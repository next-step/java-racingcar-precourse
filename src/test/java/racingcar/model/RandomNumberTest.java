package racingcar.model;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberTest {

    @RepeatedTest(100)
    void 랜덤값_생성_테스트_0_9() {
        int randmonNumber = RandomNumber.makeNumber();

        assertThat(randmonNumber <= 9).isTrue();
        assertThat(randmonNumber >= 0).isTrue();

        assertThat(randmonNumber < 0).isFalse();
        assertThat(randmonNumber > 9).isFalse();
    }
}