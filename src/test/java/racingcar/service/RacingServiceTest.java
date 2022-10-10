package racingcar.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.RacingCars;

class RacingServiceTest {
    RacingService racingService = null;

    @BeforeEach
    void setUp() {
        String inputValue = "a,b,c,d";
        racingService = new RacingService();
        racingService.getRacingCars().createCar(inputValue);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,a", "1,b", "2,c", "3,d"})
    void 라운드_원(int index, String carName) {
        // given
        // when
        racingService.round();
        RacingCars racingCars = racingService.getRacingCars();
        // then
        assertEquals(racingCars.getCarList().get(index).getName(), carName);

    }

}