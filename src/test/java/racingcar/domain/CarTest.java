package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("Car 객체 생성 및 play 테스트")
    @Test
    void set() {
        Car car = new Car("pobi");
        car.move(3);
        car.move(4);
        assertThat(car).isEqualTo(new Car("pobi", 1));
    }

    @DisplayName("우승자 비교 테스트")
    @ParameterizedTest
    @CsvSource(value = {"pobi,2,crong,1,true", "pobi,1,crong,1,true", "pobi,1,crong,2,false"}, delimiter = ',')
    void compare(String name, int position, String name2, int position2, boolean expected) {
        Car car = new Car(name, position);
        Car car2 = new Car(name2, position2);
        assertThat(car.compareWinner(car2)).isEqualTo(expected);
    }
}
