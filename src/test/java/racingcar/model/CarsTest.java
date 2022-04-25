package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    private Car naverCar;
    private Car kakaoCar;
    private Cars cars;

    @BeforeEach
    void Cars() {
        naverCar = new Car(new CarName("naver"));
        kakaoCar = new Car(new CarName("kakao"));
        cars = new Cars(Arrays.asList(naverCar, kakaoCar));
    }

    @Test
    void 자동차_움직임_테스트() {
        cars.move(Arrays.asList(5, 3));

        assertThat(cars.getCars().get(0).getPosition()).isEqualTo("-");
        assertThat(cars.getCars().get(1).getPosition()).isEqualTo("");
    }


}
