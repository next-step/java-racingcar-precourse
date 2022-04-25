package racingcar.domain.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.NextStepCar;
import racingcar.domain.cars.Cars;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NextStepCarFactoryTest {

    @Test
    @DisplayName("NextStepCarFactory에 자동차들의 String값에 자동차 이름이 없을때 에러를 발생시키는지 확인한다.")
    void 자동차_갯수_0_에러_확인() {
        assertThatThrownBy(
                () -> new NextStepCarFactory()
                        .makeCar("")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주할 자동차를 1대 이상 입력해 주세요.");
    }

    @Test
    @DisplayName("NextStepCarFactory에 자동차들의 String값을 입력 중 이름의 길이가 조건에 맞지 않을때 에러를 발생시키는지 확인한다.")
    void 자동차_이름_에러_확인() {
        assertThatThrownBy(
                () -> new NextStepCarFactory()
                        .makeCar("carcarcar, car2")
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름의 길이가 잘못되었습니다.");
    }
    
    @Test
    @DisplayName("NextStepCarFactory에 자동차들의 String값을 입력 시 객체를 정상적으로 생성하는지 확인한다.")
    void 리스트_정상_반환_확인() {
        Cars cars = new NextStepCarFactory()
                .makeCar("car1,car2");

        assertEquals("car1", cars.getCars().get(0).getName(),"설정된 첫번째 자동차는 'car1'이여야 합니다.");
        assertEquals("car2", cars.getCars().get(1).getName(),"설정된 첫번째 자동차는 'car2'이여야 합니다.");

        assertTrue(cars.getCars().get(0) instanceof NextStepCar,"설정된 자동차는 NextStepCar 객체여야 합니다.");
        assertTrue(cars.getCars().get(1) instanceof NextStepCar,"설정된 자동차는 NextStepCar 객체여야 합니다.");

    }

}