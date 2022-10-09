package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void carNametest() {
        Cars testcars = new Cars("car1,car2,car3".split(","));

        assertThat(testcars.getRacingCars().get(0).getCarName()).isEqualTo("car1");

        assertThat(testcars.getRacingCars().get(1).getCarName()).isEqualTo("car2");
        assertThat(testcars.getRacingCars().get(2).getCarName()).isEqualTo("car3");
    }

    @Test
    void 위치테스트() {
        Cars testcars = new Cars("car1,car2,car3".split(","));

        testcars.getRacingCar(0).setPosition(5);
        testcars.getRacingCar(1).setPosition(5);
        testcars.getRacingCar(2).setPosition(3);

        assertThat(testcars.getRacingCarPosition(0)).isEqualTo(5);

    }

}
