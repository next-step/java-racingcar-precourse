package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racinggame.Fixture.*;
import static racinggame.Fixture.CAR_C;

class CarsTest {

    @DisplayName("String split 테스트")
    @Test
    void stringSplit() {
        String dummy = INPUT;

        String[] split = dummy.split(",");

        assertThat(split[0]).isEqualTo(CAR_A);
        assertThat(split[1]).isEqualTo(CAR_B);
        assertThat(split[2]).isEqualTo(CAR_C);
    }

    @DisplayName("자동차 이름 split 테스트")
    @Test
    void enterName_case1() {
        Cars cars = new Cars();

        cars.enterName(INPUT);

        assertThat(cars.getCars().get(0).getName()).isEqualTo(CAR_A);
        assertThat(cars.getCars().get(1).getName()).isEqualTo(CAR_B);
        assertThat(cars.getCars().get(2).getName()).isEqualTo(CAR_C);
    }

    @DisplayName("자동차 길이 테스트")
    @Test
    void enterName_case2() {
        Cars cars = new Cars();

        assertThrows(IllegalArgumentException.class, () -> cars.enterName(ILLEGAL_INPUT));
    }
}