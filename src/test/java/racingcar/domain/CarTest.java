package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    
    @Test
    void Car_도메인_Name_확인() {
        //given
        String nameString = "자동차";

        //when
        Car car = Car.of(nameString);
        Name name = new Name(nameString);

        //then
        assertThat(car.getName().getName()).isEqualTo(name.getName());
    }

    @Test
    void Car_도메인_Move_확인() {
        //given
        String nameString = "자동차";

        //when
        Car car = Car.of(nameString);
        car.getMove().goDistance();

        //then
        assertThat(car.getMove().getDistance()).isEqualTo(1);
    }
}
