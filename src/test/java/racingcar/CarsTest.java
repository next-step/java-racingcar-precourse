package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarsTest {
    
    @Test
    void 자동차_쉼표_분리_Test() throws Exception {
        /** When **/
        Cars cars = new Cars("car1,car2,car3");

        /** Then **/
        assertThat(cars.getCars()).isNotNull();
        assertThat(cars.getCarsSize()).isEqualTo(3);
    }

}
