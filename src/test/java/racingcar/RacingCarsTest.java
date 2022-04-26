package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class RacingCarsTest {

    @Test
    void 자동차를_5대_생성() {
        RacingCars racingCars = new RacingCars("sae,rang,pro,free,pass");


        assertThat(racingCars.getRacingCars()).hasSize(5)
                                              .extracting("racingCarName")
                                              .containsExactly(
                                                      new RacingCarName("sae"),
                                                      new RacingCarName("rang"),
                                                      new RacingCarName("pro"),
                                                      new RacingCarName("free"),
                                                      new RacingCarName("pass"));
    }

    @Test
    void 자동차_경주_2명_시작() {
        RacingCars racingCars = new RacingCars("sae,rang");
        racingCars.start(new TestRandomNumberGenerator(Arrays.asList(4, 1)));

        assertThat(racingCars.getRacingCars()).hasSize(2)
                                              .extracting("racingCarName", "location")
                                              .containsExactly(
                                                      tuple(new RacingCarName("sae"), "-"),
                                                      tuple(new RacingCarName("rang"), ""));
    }

    @Test
    void 자동차_경주_3명_시작() {
        RacingCars racingCars = new RacingCars("sae,rang,free");
        racingCars.start(new TestRandomNumberGenerator(Arrays.asList(4, 1, 4)));

        assertThat(racingCars.getRacingCars()).hasSize(3)
                                              .extracting("racingCarName", "location")
                                              .containsExactly(tuple(new RacingCarName("sae"), "-"),
                                                               tuple(new RacingCarName("rang"), ""),
                                                               tuple(new RacingCarName("free"), "-"));
    }

}
