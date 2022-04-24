package racingcar.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private static Cars cars;

    @BeforeAll
    static void initAll() {
        cars = new Cars();
    }

    @Test
    void 자동차그룹_내_자동차이름_출력() {
        cars.add(new Car("one"));
        cars.add(new Car("two"));

        assertThat(cars.get(0).getName()).isEqualTo("one");
        assertThat(cars.get(1).getName()).isEqualTo("two");
    }

    @Test
    void 자동차그룹_초기화() {
        cars.add(new Car("one"));
        assertThat(cars.getCars().isEmpty()).isFalse();

        cars.clear();
        assertThat(cars.getCars().isEmpty()).isTrue();
    }
}