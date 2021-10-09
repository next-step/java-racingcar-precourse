package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void 이동_테스트() {
        CarFacroty carFacroty = new CarFacroty("퐁당퐁");
        Cars cars = carFacroty.enter();
        cars.play(Collections.singletonList(1));
        assertThat(cars.getCarsSize()).isEqualTo(1);
    }

    @Test
    void 한번_이동_후_순위_단일우승_테스트() {
        CarFacroty carFacroty = new CarFacroty("퐁당퐁,퐁당퐁당");
        Cars cars = carFacroty.enter();
        cars.play(Arrays.asList(1, 5));
        assertThat(cars.winner()).contains("퐁당퐁당");
    }

    @Test
    void 한번_이동_후_순위_공동우승_테스트() {
        CarFacroty carFacroty = new CarFacroty("퐁당퐁,퐁당퐁당,퐁당퐁당퐁");
        Cars cars = carFacroty.enter();
        cars.play(Arrays.asList(1, 5, 6));
        assertThat(cars.winner()).contains("퐁당퐁당,퐁당퐁당퐁");
    }

    @Test
    void 다섯번_이동_후_순위_공동우승_테스트() {
        CarFacroty carFacroty = new CarFacroty("퐁당퐁,퐁당퐁당,퐁당퐁당퐁");
        Cars cars = carFacroty.enter();
        int attempt = 5;
        for (int i = 0; i < attempt; i++) {
            cars.play(Arrays.asList(1, 5, 6));
        }
        assertThat(cars.winner()).contains("퐁당퐁당,퐁당퐁당퐁");
    }
}
