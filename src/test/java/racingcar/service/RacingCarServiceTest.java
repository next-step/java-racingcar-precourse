package racingcar.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.Circuit;
import racingcar.model.UserCarRacingRequest;
import racingcar.model.UserTrialRequest;

class RacingCarServiceTest {

    private final RacingCarService racingCarService;

    private RacingCarServiceTest(){
        racingCarService = new RacingCarService(new Circuit());
    }

    @ParameterizedTest
    @CsvSource({"'car1,car2',2","'car1,car2,car3',3"})
    @DisplayName("registerCarListTest:[success]")
    void registerCarListTest(String input, int expected) {
        //given
        UserCarRacingRequest userCarRacingRequest = UserCarRacingRequest.valueOf(input);
        //when
        racingCarService.registerCarList(userCarRacingRequest);
        //then
        assertThat(racingCarService.getCurrentTrackStatus()).hasSize(expected);
    }

    @ParameterizedTest
    @CsvSource({"1,true","0,false"})
    @DisplayName("registerLapsTest:[success]")
    void registerLapsTest(String input, boolean expected) {
        //given
        UserTrialRequest userTrialRequest = UserTrialRequest.valueOf(input);
        //when
        racingCarService.registerLaps(userTrialRequest);
        //then
        assertThat(racingCarService.haveLaps()).isEqualTo(expected);
    }

    @Test
    @DisplayName("raceTest:[success]")
    void race() {
        //given
        UserCarRacingRequest userCarRacingRequest = UserCarRacingRequest.valueOf("car1,car2,car3");
        UserTrialRequest userTrialRequest = UserTrialRequest.valueOf("1");
        //when
        racingCarService.registerCarList(userCarRacingRequest);
        racingCarService.registerLaps(userTrialRequest);
        //then
        assertThat(racingCarService.haveLaps()).isTrue();
        racingCarService.race();
        assertThat(racingCarService.haveLaps()).isFalse();
    }

    @Test
    @DisplayName("getWinnerListStringTest:[success]")
    void getWinnerListString() {
        //given
        UserCarRacingRequest userCarRacingRequest = UserCarRacingRequest.valueOf("car1,car2,car3");
        UserTrialRequest userTrialRequest = UserTrialRequest.valueOf("0");
        //when
        racingCarService.registerCarList(userCarRacingRequest);
        racingCarService.registerLaps(userTrialRequest);
        //then
        assertThat(racingCarService.getWinnerListString()).containsAnyOf("car1","car2","car3");
    }
}