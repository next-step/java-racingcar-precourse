package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {
    @DisplayName("자동차 이름 길이 테스트")
    @ParameterizedTest
    @CsvSource(value = {"K5:2", "소나타:3", "벤츠:2", "차:1", "하이브리드:5"}, delimiter = ':')
    void carNameLengthTest(String name, int length) {
        CarName carName = new CarName(name);
        assertThat(carName.getName().length()).isEqualTo(length);
    }

    @DisplayName("자동차 이름 길이 유효성 검사")
    @ParameterizedTest
    @ValueSource(strings = {"벤츠C클래스", "빨간색자동차", "띄어 쓰기용", "긴자동차이름입니다."})
    void carNameValidTest(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(name));
    }

    @DisplayName("자동차 이름 길이 0 테스트")
    @Test
    void carNameZeroLengthTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(""));
    }

    @DisplayName("자동차 이름 null 테스트")
    @Test
    void carNameNullTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(null));
    }
}
