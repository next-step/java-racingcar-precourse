package racingcargame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcargame.exception.NameLengthExceededException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    @DisplayName("4이상의 숫자가 입력되었을 때 전진한다.")
    void moveTest(Integer input, Integer expectedMileage) {
        // given
        Car movedCar = Car.of("테스트");

        // when
        movedCar.move(input);

        // then
        assertThat(movedCar.getMileage()).isEqualTo(Mileage.of(expectedMileage));
    }

    @Test
    @DisplayName("이름이 5자를 초과하면 예외가 발생한다.")
    void carNameTest() {
        // given
        String exceededName = "abcdef";

        assertThatThrownBy(() -> {
            // when
            Car.of(exceededName);
        })
                // then
                .isInstanceOf(NameLengthExceededException.class)
                .hasMessageContaining("이름이 다섯 글자를 초과할 수 없습니다");

    }
}