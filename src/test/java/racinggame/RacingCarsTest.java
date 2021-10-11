package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        racingCars = new RacingCars("pobi,crong,honux");
    }

    @Test
    @DisplayName("참가 자동차 목록 생성")
    void 참가_자동차_목록_생성() {
        assertThat(racingCars.getRacingCarList().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("우승자 구하기")
    void 우승자_구하기() {
        racingCars.racing();
        String result = racingCars.getWinningCarName();
        assertThat(result).isNotEqualTo("");
    }

}
