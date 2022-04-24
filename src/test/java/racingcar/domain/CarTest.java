package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.Configuration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.ThrowableAssert.ThrowingCallable;

class CarTest {
    @Test
    @DisplayName("정상 이름의 차 생성 테스트")
    void createCarTest() {
        String name = "abc";
        Car car = new Car(name, Configuration.MIN_DISTANCE);
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("이름이 올바르지 않은 경우의 차 생성 테스트")
    void createCarTestWithInvalidName() {
        ThrowingCallable emptyName = () -> new Car("", Configuration.MIN_DISTANCE);
        assertThatThrownBy(emptyName).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 5자 초과인 경우의 차 생성 테스트")
    void createCarTestWithTooLongName() {
        ThrowingCallable tooLongName = () -> new Car("abcdefg", Configuration.MIN_DISTANCE);
        assertThatThrownBy(tooLongName).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 초기 거리 설정이 잘못된 경우")
    void createCarTestWithInvalidDistance() {
        ThrowingCallable distanceIsNotZero = () -> new Car("test", 2312);
        assertThatThrownBy(distanceIsNotZero).isInstanceOf(IllegalArgumentException.class);
    }
}
