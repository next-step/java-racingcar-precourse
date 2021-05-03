package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class RacingCarsTest {

    @Test
    void splitArrayToRacingCarsTest() {
        String names = "aaaa,bbbb,cccc,dddd,eeee,ffff";
        RacingCars racingCars = new RacingCars();

        for(String name : names.split(",")){
            racingCars.carList.add(new Car(name));
        }

        assertThat(racingCars.carList.size()).isEqualTo(6);
    }

}
