package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.constant.ErrorMessage;
import racingcar.exception.InvalidCarNameSizeException;

public class CarTest {

    @ParameterizedTest(name = "사용자 입력: {0}")
    @CsvSource({"1", "1234"})
    @DisplayName("자동차 이름이 1 ~ 5자라면 정상 생성되는지 검증")
    void validCharNameSize(String carName) {

        // given
        Car car = new Car(new Name(carName));

        // then
        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    @DisplayName("자동차 이름이 6자 이상이라면 InvalidCarNameSizeException 발생")
    void inValidCarNameSize() {

        // given
        String carName = "123456";

        // then
        assertThatThrownBy(() -> new Car(new Name(carName)))
                .isInstanceOf(InvalidCarNameSizeException.class)
                .hasMessageContaining(ErrorMessage.INVALID_CAR_NAME);
    }

    @Test
    @DisplayName("Car의 move() 메서드 호출시 MovementAction이 MOVE라면 한 칸 이동 검증")
    void move() {

        // given
        Car car = new Car(new Name("kyh"));

        // when
        car.move(MovementAction.MOVE);

        // then
        assertThat(car.getPosition().getValue()).isEqualTo(1);
    }

    @Test
    @DisplayName("Car의 move() 메서드 호출시 MovementAction이 STOP이라면 정지 검증")
    void stop() {

        // given
        Car car = new Car(new Name("kyh"));

        // when
        car.move(MovementAction.STOP);

        // then
        assertThat(car.getPosition().getValue()).isEqualTo(0);
    }
}
