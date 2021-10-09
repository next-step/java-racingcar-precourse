package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @DisplayName("전달 받은 이름으로 자동차 이름을 가져올 수 있는지 테스트")
    @Test
    void getName_success() {
        String name = "test";
        Car car = new Car("test");

        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 1스텝 전진 성공 테스트")
    @Test
    void moveForward_success() {
        Car car = new Car("test");
        car.moveForward();
        assertThat(car.getStep()).isEqualTo(1);
        car.moveForward();
        assertThat(car.getStep()).isEqualTo(2);
    }

    @DisplayName("자동차 이름 5글자 이하일 때 성공 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345"})
    void constructCar_successWhenNameLengthIs5OrLess(String name) {
        new Car(name);
    }

    @DisplayName("자동차 이름 5글자 이상 또는 null이나 비어있을 때 에러 던지는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void constructCar_throwsErrorWhenNameIsNullOrEmptyOrHigherThan5(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Car(name))
            .withMessageContaining("5글자 이상 또는 비어있는 이름으로 자동차를 생성할 수 없습니다.");
    }

    @DisplayName("3이상 9이하일 때만 전진하는지 테스트")
    @Test
    void moveForwardOrStop_success() {
        Car car = new Car("test");
        car.moveForwardOrStop(0);
        assertThat(car.getStep()).isEqualTo(0);
        car.moveForwardOrStop(3);
        assertThat(car.getStep()).isEqualTo(0);
        car.moveForwardOrStop(4);
        assertThat(car.getStep()).isEqualTo(1);
        car.moveForwardOrStop(9);
        assertThat(car.getStep()).isEqualTo(2);
    }

    @DisplayName("범위 밖의 숫자로 전진하려고 할 때 에러 던지는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void moveForwardOrStop_throwsException(int randomNumber) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Car("test").moveForwardOrStop(randomNumber))
            .withMessageContaining("0에서 9 사이의 숫자로만 이동할지 판단 가능합니다.");
    }

}