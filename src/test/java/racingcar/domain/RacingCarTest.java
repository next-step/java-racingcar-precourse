package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingCarTest {

    @Test
    void 단일_자동차_경주_2회_결과_출력() {
        RacingCar racingCar = new RacingCar(new RacingCarName("bob"));
        racingCar.racing(new RacingNumber(1));
        racingCar.racing(new RacingNumber(2));
        assertThat(racingCar.printCurrentRacingLocation()).isEqualTo("bob : ");
    }

    @ParameterizedTest
    @CsvSource(value = {"0", "1", "2", "3"})
    void 단일_자동차_경주_1회_결과_멈춤(int number) {
        RacingCar racingCar = new RacingCar(new RacingCarName("bob"));
        racingCar.racing(new RacingNumber(number));
        assertThat(racingCar.getCurrentLocation()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"4", "5", "6", "7", "8", "9"})
    void 단일_자동차_경주_1회_결과_전진(int number) {
        RacingCar racingCar = new RacingCar(new RacingCarName("bob"));
        racingCar.racing(new RacingNumber(number));
        assertThat(racingCar.getCurrentLocation()).isEqualTo(1);
    }

}
