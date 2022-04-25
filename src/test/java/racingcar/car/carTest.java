package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class carTest {
    
    @Test
    void go_and_stop_car(){
        Car car = new Car("TEST");

        car.inputScore(Car.GO_MIN_SCORE - 1);
        assertThat(car.getMove()).isEqualTo(0);

        car.inputScore(Car.GO_MIN_SCORE);
        assertThat(car.getMove()).isEqualTo(1);
    }

    @Test
    void name_validation(){
        String tooLongName = "ERROR_NAME";
        assertThatThrownBy(() -> new Car(tooLongName)).isInstanceOf(IllegalArgumentException.class);

        String emptyName = "";
        assertThatThrownBy(() -> new Car(emptyName)).isInstanceOf(IllegalArgumentException.class);
    }
}
