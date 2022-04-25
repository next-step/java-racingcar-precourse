package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class ManageCarTest {

    private ManageCar manageCar;

    @BeforeEach
    void gameSetUp() {
        manageCar = new ManageCar("pobi,java", "2");
    }

    @Test
    void 게임결과_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    manageCar.playGame();
                    assertThat(manageCar.getWinnerList()).contains("java");
                },
                0, 4
        );
    }

    @Test
    void 차량들_전진_테스트() {
        for(int i=0; i<10; i++) {
            manageCar.carMoveForward();
        }
        assertThat(manageCar.getHighScore()).isGreaterThanOrEqualTo(0);
    }

    @Test
    void 우승자_확인_테스트() {
        manageCar.getCarInfo(0).moveCurrentPoint(1);
        manageCar.getCarInfo(1).moveCurrentPoint(0);

        manageCar.getCarInfoList().forEach(carInfo -> manageCar.getWinnerInfo(manageCar.getWinnerList(), carInfo));

        assertThat(manageCar.getWinnerList().toString()).contains(manageCar.getCarInfo(0).getName());
    }
}