package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.engine.Engine;
import racingcar.generator.TestNumberGenerator;

class CarTest {

    @Test
    @DisplayName("이름을 가진 Car 도메인을 생성한다.")
    void generate01() {
        // given
        // when
        Car car = Car.from(Name.from("자동차_1"));

        // then
        Assertions.assertEquals("자동차_1", car.getName());
    }

    @ParameterizedTest
    @DisplayName("이름을 가진 Car 도메인을 생성한다. ParameterizedTest 이용")
    @ValueSource(strings = {"자동차_1", "자동차_2"})
    void generate02(String value) {
        // given
        // when
        Car car = Car.from(Name.from(value));

        // then
        Assertions.assertEquals(value, car.getName());
    }

    @ParameterizedTest
    @DisplayName("5자가 넘는 이름을 가진 자동차 도메인 생성")
    @ValueSource(strings = {"자동차_11111", "자동차_22222"})
    void generateException01(String value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Car.from(Name.from(value)))
                .withMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @DisplayName("이름이 공란인 자동차 도메인 생성")
    @ValueSource(strings = {""})
    void generateException02(String value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Car.from(Name.from(value)))
                .withMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @DisplayName("Car 도메인을 생성하면 초기 거리 값이 0이다.")
    @ValueSource(strings = {"자동차_1", "자동차_2"})
    void generateWithDistance01(String value) {
        // given
        // when
        Car car = Car.from(Name.from(value));

        // then
        Assertions.assertEquals(0, car.getDistance());
    }

    @ParameterizedTest
    @DisplayName("Engine을 가지는 Car 도메인을 생성하여 전진을 테스트 한다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void generateWithEngine01(Integer randomValue) {
        // given
        Engine engine = Engine.createBy(new TestNumberGenerator(randomValue));
        Car car = Car.of(Name.from("자동차_1"), engine);

        // when
        car.run();

        // then
        Assertions.assertEquals(1, car.getDistance());
    }

    @ParameterizedTest
    @DisplayName("Engine을 가지는 Car 도메인을 생성하여 멈춤 테스트 한다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void generateWithEngine02(Integer randomValue) {
        // given
        Engine engine = Engine.createBy(new TestNumberGenerator(randomValue));
        Car car = Car.of(Name.from("자동차_1"), engine);

        // when
        car.run();

        // then
        Assertions.assertEquals(0, car.getDistance());
    }
}