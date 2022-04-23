package racingcar.model.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;
import racingcar.car.model.dto.CarDTO;
import racingcar.car.model.domain.CarsManager;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CarsManagerTest extends NsTest {
    private CarsManager cars;

    @BeforeEach
    public void initCarsTest() {
        cars = new CarsManager("c1,c2,c3");

        assertRandomNumberInRangeTest(() -> {
            for (int i = 0; i < 9; i++) {
                cars.move();
            }
        }, 3, 8, 5, 5, 5, 6, 2, 1, 2, 1, 7, 5, 9, 9, 4, 6, 2, 1, 7, 0, 2, 4, 2, 8, 2, 4, 7);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    @ParameterizedTest
    @ValueSource(strings = {"t1,t2,t3,t4,t5", "t,t,t,t,t", "ttttt,tttt,tttt,tttt,tttt"})
    public void 문자열로부터_차생성하기_정상동작(String input) {
        CarsManager cars = new CarsManager(input);
        assertThat(cars).isInstanceOf(CarsManager.class);
    }

    @Test
    public void Cars를통한CarMove호출() {
        assertRandomNumberInRangeTest(() -> {
            ArrayList<CarDTO> moveResult = cars.move();
            assertThat(moveResult.get(0).getLocation())
                    .isEqualTo(6);
            assertThat(moveResult.get(1).getLocation())
                    .isEqualTo(6);
            assertThat(moveResult.get(2).getLocation())
                    .isEqualTo(7);
        }, 8, 9, 4);
    }

    @Test
    public void Car우승자_단일추출() {
        ArrayList<CarDTO> winnerList = this.cars.electWinner();
        assertThat(winnerList.get(0).getName()).isEqualTo("c3");
    }

    @Test
    public void Car우승자_다수추출() {
        assertRandomNumberInRangeTest(() -> {
            cars.move();
        }, 3, 4, 3);
        ArrayList<CarDTO> winnerList_1stTry = this.cars.electWinner();
        assertThat(winnerList_1stTry.get(0).getName()).isEqualTo("c2");
        assertThat(winnerList_1stTry.get(1).getName()).isEqualTo("c3");

        assertRandomNumberInRangeTest(() -> {
            this.cars.move();
        }, 4, 3, 3);
        ArrayList<CarDTO> winnerList_2ndTry = this.cars.electWinner();
        assertThat(winnerList_2ndTry.get(0).getName()).isEqualTo("c1");
        assertThat(winnerList_2ndTry.get(1).getName()).isEqualTo("c2");
        assertThat(winnerList_2ndTry.get(2).getName()).isEqualTo("c3");
    }
}
