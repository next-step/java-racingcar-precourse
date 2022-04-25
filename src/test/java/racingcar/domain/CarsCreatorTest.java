package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarsCreatorTest {
    CarsCreator sut;

    @Test
    void 문자열을_받으면_Cars_를_생성한다() {
        sut = CarsCreator.create();

        Cars cars = sut.createCarsBy("a,b,c");

        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.size()).isNotEqualTo(4);
    }
}