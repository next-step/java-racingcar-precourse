package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;
import racinggame.dto.constant.RacingGameStatusConstant;
import racinggame.util.RacingCarUtil;

public class RacingGameTest {
	@DisplayName("createRacingCar 테스트")
	@Test
	void RacingGameTest() {
        List<RacingCar> racingCarList = RacingCarUtil.createRacingCars("nankisu");
        RacingGame racingGeme = new RacingGame(3, racingCarList);
        assertThat(racingGeme.getRacingGameStatus()).isEqualByComparingTo(RacingGameStatusConstant.INITED);
        
        racingGeme.runRacingCarList();;
        assertThat(racingGeme.getRacingGameStatus()).isEqualByComparingTo(RacingGameStatusConstant.RUNNING);
        
        racingGeme.runRacingCarList();
        assertThat(racingGeme.getRacingGameStatus()).isEqualByComparingTo(RacingGameStatusConstant.RUNNING);
        
        racingGeme.runRacingCarList();
        assertThat(racingGeme.getRacingGameStatus()).isEqualByComparingTo(RacingGameStatusConstant.FINISH);
	}
}
