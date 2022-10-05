package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private static final List<Car> carList = new ArrayList<>();

    @BeforeAll
    static void init() {
        carList.add(Car.valueOf("Lamborghini Aventador", 0));
        carList.add(Car.valueOf("Hyundai Tuscani", 0));
        carList.add(Car.valueOf("Porsche Boxster", 0));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Lamborghini Aventador", "Hyundai Tuscani", "Porsche Boxster"})
    @DisplayName("valueOfTest:[success]")
    void valueOfTest(String input) {
        //when
        Car car = Car.valueOf(input, 0);
        //then
        assertThat(car).isInstanceOf(Car.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Lamborghini Aventador", "Hyundai Tuscani", "Porsche Boxster"})
    @DisplayName("equalsTest:[success]")
    void equalsTest(String input) {
        //when
        Car car = Car.valueOf(input, 0);
        //then
        assertThat(carList).contains(car);
    }

    @Test
    @DisplayName("increaseProgressTest:[success]")
    void increaseProgressTest() {
        //given
        String carName = "Avante";
        //when
        Car car = Car.valueOf(carName, 0);
        car.increaseProgress();
        car.increaseProgress();
        //then
        assertThat(car.toString()).isEqualTo("Avante : --");
    }


    @ParameterizedTest
    @CsvSource({
            "Lamborghini Aventador, Lamborghini Aventador : -",
            "Hyundai Tuscani, Hyundai Tuscani : -",
            "Porsche Boxster, Porsche Boxster : -"
    })
    @DisplayName("toStringTest:[success]")
    void toStringTest(String input, String expect) {
        //when
        Car car = Car.valueOf(input, 1);
        //then
        assertThat(car.toString()).isEqualTo(expect);
    }
}