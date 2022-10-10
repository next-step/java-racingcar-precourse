package racingcar.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("name", "0");

    }

    @Test
    public void 자동차_이름_유효성_검증() {
        assertThatThrownBy(() -> {
            new Car("javaji");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    public void 자동차_이름_길이제한_유효성_검증() {
        CarName carName = new CarName();
        Assertions.assertThat(carName.validCarNameLength("testcase")).isFalse();
        Assertions.assertThat(carName.validCarNameLength("pobi")).isTrue();
        Assertions.assertThat(carName.validCarNameLength("crong")).isTrue();
    }


    @Test
    public void 자동차_전진_유효성_검증() {
        Assertions.assertThat(car.validMove(4)).isTrue();
        Assertions.assertThat(car.validMove(5)).isTrue();
        Assertions.assertThat(car.validMove(3)).isFalse();
        Assertions.assertThat(car.validMove(-1)).isFalse();
    }

    @Test
    public void 자동차_전진_검증() {
        Assertions.assertThat(car.move(4)).isEqualTo(1);
        Assertions.assertThat(car.move(3)).isEqualTo(1);
        Assertions.assertThat(car.move(5)).isEqualTo(2);
    }

    @Test
    public void 자동차_이름_부여_검증() {
        //given
        car = new Car("woni");

        //when
        String result = car.getName();

        //then
        Assertions.assertThat(result).isEqualTo("woni");
    }


}