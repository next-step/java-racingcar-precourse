package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("Constructor valid input test")
    void constructorValidInputTest() throws Exception {
        //given
        String input = "abcd";
        String expectedName = "abcd";
        int expectedPosition = 0;

        //when
        Car car = new Car(input);
        String resultName = car.getName();
        int resultPosition = car.getPosition();

        //then
        assertThat(resultName).isEqualTo(expectedName);
        assertThat(resultPosition).isEqualTo(expectedPosition);
    }

    @Test
    @DisplayName("Constructor invalid input test")
    void constructorInvalidInputTest() throws Exception {
        //given
        String input = "carname";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car(input);
        }, "[ERROR] 자동차의 이름은 5자 이하만 가능합니다.");
    }
}