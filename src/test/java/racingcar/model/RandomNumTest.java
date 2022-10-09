package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomNumTest {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;

    @DisplayName("0~9에 맞지 않는 숫자를 넣을 경우 강제로 조정하는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, 10, 100, 10000})
    void failTest(int input) {
        assertThat(new RandomNum(input).getNum()).isBetween(START_INCLUSIVE, END_INCLUSIVE);
    }

    @DisplayName("범위에 맞는 숫자를 잘 생성하는지 반복 테스트")
    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    void repeatTest() {
        assertThat(new RandomNum().getNum()).isBetween(START_INCLUSIVE, END_INCLUSIVE);
    }
}