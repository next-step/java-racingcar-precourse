package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class RacingCarsTest {
    RacingCars racingCars;
    @BeforeEach
    void setUp() {
        String names = "aaaa,bbbb,cccc,dddd,eeee,ffff";
        racingCars = new RacingCars();

        for(String name : names.split(",")){
            racingCars.carList.add(new Car(name));
        }
    }

    @DisplayName("자동차 , split 후 생성")
    @Test
    void splitArrayToRacingCarsTest() {
        assertThat(racingCars.carList.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("자동차들 전진 테스트")
    void racingCarsForwardTest() {
        for (Car car : racingCars.carList){
            car.forward();
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

}
