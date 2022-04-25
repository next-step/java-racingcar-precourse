package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {

    @DisplayName("자동차의 이름은 5자 이하만 가능하다.")
    @Test
    public void carNameIsShorter5() {
        // when
        CarName carName = new CarName("그랜져");
    }

    @DisplayName("자동차의 이름이 5자 보다 클 경우 에러가 발생한다.")
    @Test
    public void carNameIsLonger5WithError() {
        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new CarName("제네시스G80")
        );
        // then
        assertThat(exception.getMessage()).isNotNull();
    }

    @DisplayName("자동차의 이름은 1글자 이상이어야 한다.")
    @ParameterizedTest
    @MethodSource
    public void carNameIsNotEmpty(String name) {
        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new CarName(name)
        );
        // then
        assertThat(exception.getMessage()).isNotNull();
    }

    private static Stream<String> carNameIsNotEmpty() {
        return Stream.of("", "   ", null);
    }

}