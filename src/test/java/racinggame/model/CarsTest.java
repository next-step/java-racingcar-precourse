package racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarsTest {

    @Test
    @DisplayName("자동차이름_쉼표구분_검증")
    void 자동차이름_쉼표구분_검증() {
        ArrayList<Car> carList = new ArrayList<Car>();
        carList.add(new Car("lia",0));
        carList.add(new Car("tony",0));
        carList.add(new Car("test",0));

        assertThat(Cars.makeCarsByInputName("lia, tony, test")).hasSize(3);
        //assertEquals(Cars.makeCarsByInputName("lia, tony, test"), carList);
    }

}