package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class RacingCarTest {
    @DisplayName("자동차 이름은 중복 불가")
    @Test
    void isDifferentCarName() throws Exception{
        //given
        String racingCarName = "yoni";
        RacingCar car = new RacingCar(racingCarName, 1);

        List<RacingCar> cars = List.of(car, car);

        //when //then
        Assertions.assertThatThrownBy(() -> new RacingCars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복으로 사용 불가");
    }

    @DisplayName("자동차 경주를 하기위해 자동차는 최소 2대이상 생성해야 함")
    @Test
    void minimumCountOfCars() throws Exception{
        //given
        String racingCarName = "pobi";
        RacingCar car = new RacingCar(racingCarName, 1);

        List<RacingCar> cars = List.of(car);

        //when //then
        Assertions.assertThatThrownBy(() -> new RacingCars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 최소 2대 이상 생성해야 함");
    }
}
