package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.ui.ConsoleMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("자동차 도메인 테스트")
class CarTest {

    @ParameterizedTest(name = "{displayName} [input : {arguments}]")
    @ValueSource(strings = {"gyeom", "a", " abc "})
    @DisplayName("자동차 생성 성공")
    void constructor(String input) {
        // when
        Car car = new Car(input);

        // then
        assertAll(
                () -> assertThat(car.getCarName()).isEqualTo(input.trim()),
                () -> assertThat(car.getCarPosition()).isEqualTo(0)
        );
    }

    @ParameterizedTest(name = "{displayName} [input : {arguments}]")
    @ValueSource(strings = {" ", "daegyeom"})
    @DisplayName("공백을 제외하고 빈 값이거나 5자 초과된 이름으로 자동차를 생성하면 예외를 발생한다.")
    void constructorException(String input) {
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(input))
                .withMessageMatching(ConsoleMessage.CAR_NAME_ERROR.getMessage());
    }

    @Test
    @DisplayName("자동차 전진 성공")
    void control() {
        // given
        Car car = new Car("gyeom");

        // when
        car.control(ControlType.FORWARD);

        // then
        assertThat(car.getCarPosition()).isEqualTo(1);
    }
}