package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest extends NsTest {

    private RacingCar testCar;

    @BeforeEach
    public void setUp() {
        testCar = new RacingCar("test");
    }

    @Test
    @DisplayName("레이싱카 생성 테스트")
    public void makeRacingCar() {

        String testName = "test";
        RacingCar racingCar = new RacingCar(testName);
        assertThat(racingCar.getCarName()).isEqualTo(testName);
        assertThat(racingCar.getForward()).isEqualTo(0);
    }

    @Test
    @DisplayName("한게임을 돌릴 시에 4이상일 경우 전진한다.")
    public void playGameForwardTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    testCar.playGame();
                    assertThat(testCar.getForward()).isEqualTo(1);
                },
                5, 1
        );
    }

    @Test
    @DisplayName("한게임을 돌릴 시에 3이하일 경우 전진안한다.")
    public void playGameStayTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    testCar.playGame();
                    assertThat(testCar.getForward()).isEqualTo(0);
                },
                3, 1
        );
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    @Test
    @DisplayName("현재 자동차의 위치 표시.")
    public void playGameDisplayTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    testCar.playGame();
                    testCar.display();
                    assertThat(output()).contains("test : -");
                },
                5, 1
        );
    }

    @Test
    @DisplayName("여러 대의 자동차 현재 상황 표시 테스트")
    public void playGameDisplayTest2() {

        RacingCar testCar2 = new RacingCar("김첨지");
        assertRandomNumberInRangeTest(
                () -> {
                    testCar.playGame();
                    testCar2.playGame();
                    testCar2.playGame();
                    testCar.display();
                    testCar2.display();
                    assertThat(output()).contains("test : -", "김첨지 : --");
                },
                5, 10, 10
        );
    }

}
