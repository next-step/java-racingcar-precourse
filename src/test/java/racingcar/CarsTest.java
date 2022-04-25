package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @DisplayName("여러개의 Car로 구성된다.")
    @Test
    void construct(){
        Cars cars = new Cars(Arrays.asList(new Car(new Position(0), new Name("pobi")), new Car(new Position(0), new Name("weno"))));
        assertThat(cars).isNotNull();
    }
}
