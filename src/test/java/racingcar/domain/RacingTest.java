package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @Test
    void 레이싱객체에서_값설정() {
        //given
        Cars cars = new Cars(Arrays.asList(Car.of("benz"), Car.of("audi")));
        Track track = new Track(3);

        //when
        Racing racing = new Racing(cars, track);
        List<Car> list = racing.getCars().getCars();
        Car benz = list.get(0);

        //then
        assertThat(benz.getName().getName()).isEqualTo("benz");
        assertThat(racing.getTrack().getCount()).isEqualTo(3);
    }
}
