package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarsTest extends NsTest {
    private RacingCars testRacingCars;

    @BeforeEach
    public void setUp() {
        String testInput = "K5,EV6,TAYCAN,SPORTAGE,SANTAFE";
        List<String> carNames = ValidationUtils.inputSplit(testInput);
        List<RacingCar> racingCars = RacingCars.makeNamedCars(carNames);
        testRacingCars = new RacingCars(racingCars);
    }

    @Test
    @DisplayName("레이싱 카 전체 현재 상황 표시 테스트")
    public void RacingCarsDisplayTest() {
        testRacingCars.display();
        assertThat(output()).contains("K5 :", "EV6 :", "TAYCAN :", "SPORTAGE :", "SANTAFE :");
    }

    @Test
    @DisplayName("레이싱 카 게임 시작 테스트")
    public void RacingCarsPlayGame() {
        assertRandomNumberInRangeTest(
                () -> {
                    testRacingCars.playGame();
                    testRacingCars.display();
                    assertThat(output()).contains("K5 :", "EV6 :", "TAYCAN :", "SPORTAGE : -", "SANTAFE : -");
                },
                3, 3, 3, 5, 5
        );
    }


    @Test
    @DisplayName("우승자 표시 테스트")
    public void RacingCarsWinnerDisplay() {
        assertRandomNumberInRangeTest(
                () -> {
                    testRacingCars.playGame();
                    testRacingCars.display();
                    List<String> winnerNames = testRacingCars.calculateWinner();
                    testRacingCars.displayWinner(winnerNames);
                    assertThat(output()).contains("K5 :", "EV6 :", "TAYCAN :", "SPORTAGE : -", "SANTAFE : -");
                    assertThat(output()).contains(RacingCars.FINAL_WINNER + " SPORTAGE,SANTAFE");
                },
                3, 3, 3, 5, 5
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
