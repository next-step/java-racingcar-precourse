package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.vo.RacingCar;
import racingcar.vo.RacingCars;

class RacingCarPlayServiceTest {

    private RacingCarPlayService racingCarPlayService;

    @BeforeEach
    void before() {
        racingCarPlayService = new RacingCarPlayService();
    }


    @DisplayName("입력받은 자동차이름(문자열)에 대한 자동차 목록 생성")
    @ParameterizedTest
    @CsvSource(value = "볼보,1등카,빨라용:3", delimiter = ':')
    void registerRacingCars(String inputCarNames) {
        RacingCars racingCars = racingCarPlayService.registerRacingCars(inputCarNames);
        List<RacingCar> racingCarList = racingCars.getRacingCarList();

        int idx = 0;
        for (String expectedCarName : inputCarNames.split(",")) {
            String actualCarName = racingCarList.get(idx++).getCarName();
            assertEquals(expectedCarName, actualCarName);
        }
    }
}