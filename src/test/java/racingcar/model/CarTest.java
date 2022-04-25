package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @DisplayName("5자 이하의 이름을 가진 자동차를 생성한다.")
    @Test
    public void constructor() {
        //given
        String name = "12345";

        //when
        Car car = new Car(name);

        //then
        assertEquals(name, car.getName());
    }

    @DisplayName("이름이 5자가 넘을경우, IllegalArgumentException 발생")
    @Test
    public void constructor_fail_name_length() {
        //given
        String name = "123456";

        //expect
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Car(name))
            .withMessage("[ERROR] 자동차의 이름은 5자 이하여야 한다.");
    }

    @DisplayName("자동차 이동 테스트")
    @CsvSource(value = {"true,1", "false,0"})
    @ParameterizedTest
    public void move(boolean movable, int expectedPosition) {
        //given
        Car testCar = new Car("test");

        //when
        testCar.move(() -> movable);

        //then
        assertEquals(expectedPosition, testCar.getPosition());
    }

}