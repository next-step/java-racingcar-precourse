package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    @DisplayName("각 자동자 0-9 사이의 random 값 부여")
    void racingCarRanDomNumberTest(){
        //given
        RacingCar racingCar = new RacingCar("1");

        //when
        racingCar.race();

        //then
        assertThat(racingCar.getForwardCount()).isGreaterThanOrEqualTo(0);
    }

}