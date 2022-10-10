package racingcar.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class RandomNumberTest {
    static final Integer maxValue = 10;

    @RepeatedTest(100)
    void 랜덤번호_생성_테스트() {
        // given
        RandomNumber randomNumber = new RandomNumber();
        // when
        int number = randomNumber.getNumber();
        // then
        assertThat(number).isLessThan(maxValue);
    }

}