package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberTest {

    @DisplayName("랜덤 숫자 생성 성공 테스트 - 0보다 큰지")
    @Test
    public void randomNumberGreaterThanTest() {
        // given
        int randomNumber = RandomNumber.generate();

        // when
        // then
        assertThat(randomNumber).isGreaterThan(0);
    }

    @DisplayName("랜덤 숫자 생성 성공 테스트 - 10보다 작은지")
    @Test
    public void randomNumberLessTanTest() {
        // given
        int randomNumber = RandomNumber.generate();

        // when
        // then
        assertThat(randomNumber).isLessThan(10);
    }

}
