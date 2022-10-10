package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class InputTest {
    @Test
    void parseNames() {
        String[] actual = Input.parseNames("a,b,c");
        String[] expected = {"a", "b", "c"};
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void parseCars() {
        Cars actual = Input.parseCars("a,b,c");
        Cars expected = new Cars(Arrays.asList(new Car("a"), new Car("b"), new Car("c")));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void parseTryNumber() {
        assertThat(Input.parseTryNumber("1")).isEqualTo(1);
        assertThatThrownBy(() -> Input.parseTryNumber("a")).isInstanceOf(IllegalArgumentException.class);
    }
}
