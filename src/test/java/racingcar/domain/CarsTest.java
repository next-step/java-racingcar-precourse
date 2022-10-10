package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void 공백포함_문자열은_불일치() {
        //given
        String bmw = "bmw";
        String cars = "audi, bmw, benz";

        //when
        String[] carsArray = cars.split(",");

        //then
        assertThat(carsArray[1]).isNotEqualTo(bmw);
    }

    @Test
    void 공백포함_문자열_공백제거_일치() {
        //given
        String bmw = "bmw";
        String cars = "audi, bmw, benz";

        //when
        String[] carsArray = cars.split(",");

        //then
        assertThat(carsArray[1].trim()).isEqualTo(bmw);
    }

    @Test
    void 공백포함_문자열_Cars_객체_확인() {
        //given
        String bmw = "bmw";

        //when
        Cars cars = new Cars(Arrays.asList(Car.of("audi"), Car.of("bmw"), Car.of("benz")));
        Car car = cars.getCars().get(1);

        //then
        assertThat(car.getName().getName()).isEqualTo(bmw);
    }
}
