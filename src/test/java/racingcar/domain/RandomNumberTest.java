package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class RandomNumberTest {

    @Test
    @DisplayName("0~9 사이 랜덤 숫자 생성 테스트")
    void constructor() {
        RandomNumber randomNumber = new RandomNumber();

        for (int i = 0; i < 100000; i++) {
            assertThat(randomNumber.getNumber()).isLessThan(10).isGreaterThan(-1);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:1", "4:4", "9:9"}, delimiter = ':')
    @DisplayName("0~9 사이 랜덤 숫자 생성 테스트")
    void constructor(int source, int target) {
        assertThat(new RandomNumber(source).getNumber()).isEqualTo(target);
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 10, 11})
    @DisplayName("0~9 사이가 아닌 숫자 테스트")
    void invalidNumber(int value) {
        assertThat(catchThrowable(() -> new RandomNumber(value)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
