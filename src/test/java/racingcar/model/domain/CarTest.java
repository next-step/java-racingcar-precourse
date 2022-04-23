package racingcar.model.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.car.model.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    Car t1;
    Car t2;
    Car t3;

    @BeforeEach
    public void init() {
        t1 = new Car("t1");
        t2 = new Car("t2");
        t3 = new Car("t3");
    }

    @Test
    public void Car생성하기_이름은5글자이하() {
        assertThat(new Car("POLIV")).isInstanceOf(Car.class);
        assertThat(new Car("pol")).isInstanceOf(Car.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:1", "5:1", "6:1", "7:1", "8:1", "9:1", "0:0", "1:0", "2:0", "3:0"}, delimiter = ':')
    public void Car이동시키기(int moveForRandomInput, int locationResult) {
        //given
        t1.move(moveForRandomInput);
        t2.move(moveForRandomInput);
        t3.move(moveForRandomInput);
        //when
        assertThat(t1.getLocation()).isEqualTo(locationResult);
        assertThat(t2.getLocation()).isEqualTo(locationResult);
        assertThat(t3.getLocation()).isEqualTo(locationResult);
        //then
    }

    @Test
    public void Car연속이동시키기() {
        //given
        List<Integer> inputs = Arrays.asList(1, 2, 4, 7, 3, 9, 8);
        List<Integer> positions = Arrays.asList(0, 0, 1, 2, 2, 3, 4);

        //then
        for (int i = 0; i < inputs.size(); i++) {
            t1.move(inputs.get(i));
            assertThat(t1.getLocation()).isEqualTo(positions.get(i));
        }
    }
}
