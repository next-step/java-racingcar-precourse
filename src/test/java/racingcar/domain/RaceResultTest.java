package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceResultTest {
    RaceResult sut;

    Car car1 = mock(Car.class);
    Car car2 = mock(Car.class);

    @BeforeEach
    void setUp() {
        Cars cars = Cars.empty();

        stubWith(car1, "A", "-");
        stubWith(car2, "B", "--");

        cars.add(car1);
        cars.add(car2);

        sut = RaceResult.of(cars);
    }

    @Test
    void toString_을_호출하면_자동차의_이름과_현재위치가_줄바꿈으로_출력된다() {
        String actual = sut.toString();

        assertThat(actual).isEqualTo("A : -\nB : --\n");
    }

    @Test
    void 가장_멀리간_자동차의_거리를_출력한다() {
        int longestDistance = sut.longestDistance();

        assertThat(longestDistance).isEqualTo(2);
    }

    private void stubWith(Car car, String name, String distance) {
        given(car.getName()).willReturn(name);
        given(car.getMovedDistance()).willReturn(distance);
    }
}