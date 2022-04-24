package racingcar.car.domain.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinnersTest {

    @DisplayName("승리자들 객체를 생성한다.")
    @Test
    void create_winners() {
        // given
        String name = "sjlee";

        // when, then
        assertThatCode(() -> new Winners(Collections.singletonList(new Car(name))))
                .doesNotThrowAnyException();
    }

    @DisplayName("승리자들 객체에는 항상 승리자가 한명이상 존재해야한다.")
    @Test
    void create_winners_invalid() {
        // given: none

        // when
        assertThatIllegalStateException()
                .isThrownBy(() -> new Winners(null))
                .withMessage("[ERROR] 최소 한명의 승리자가 존재해야합니다.");
    }

    @ParameterizedTest(name = "승리자들을 반환한다")
    @MethodSource("winners_to_string_parameter")
    void winners_to_string(Winners winners, String expected) {
        // given: none

        // when, then
        assertThat(winners.toString()).isEqualTo(expected);
    }

    static Stream<Arguments> winners_to_string_parameter() {
        return Stream.of(
                Arguments.of(new Winners(Arrays.asList(new Car("lee"), new Car("suk"))), "lee, suk"),
                Arguments.of(new Winners(Collections.singletonList(new Car("june"))), "june"));
    }

}