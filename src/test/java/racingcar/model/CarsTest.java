package racingcar.model;


import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static racingcar.model.CarEngine.MINIMUM_MOVE_ENERGY;

public class CarsTest extends NsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        String[] carNames = new String[]{"pobi","java","woni"};
        List<Car> carList = new ArrayList<>();
        for (String carName:carNames) {
            carList.add(Car.create(carName));
        }
        cars = new Cars(carList);
    }

    @Test
    @DisplayName("일급 컬렉션 Cars 생성 테스트")
    void carsTest() {
        assertThat(cars.getCars().size()).isEqualTo(3);
        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(()->cars.getCars().add(Car.create("test")));
    }

    @Test
    @DisplayName("Cars race 테스트")
    void raceTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1);
                    assertThat(cars.getCars().get(1).getPosition()).isEqualTo(0);
                    assertThat(cars.getCars().get(2).getPosition()).isEqualTo(1);
                },
                MINIMUM_MOVE_ENERGY, MINIMUM_MOVE_ENERGY-1, MINIMUM_MOVE_ENERGY
        );
    }

    @Test
    @DisplayName("우승자 1명일때 선택 테스트")
    void getWinnerCarTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    run();
                    run();
                    assertThat(cars.getWinnerCarNames().get(0)).isEqualTo(cars.getCars().get(0).getName());
                },
                MINIMUM_MOVE_ENERGY, MINIMUM_MOVE_ENERGY-1, MINIMUM_MOVE_ENERGY,
                MINIMUM_MOVE_ENERGY, MINIMUM_MOVE_ENERGY-1, MINIMUM_MOVE_ENERGY-1,
                MINIMUM_MOVE_ENERGY, MINIMUM_MOVE_ENERGY, MINIMUM_MOVE_ENERGY
        );
    }

    @Test
    @DisplayName("우승자 1명 이상일때 선택 테스트")
    void getWinnerCarsTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    run();
                    run();
                    assertThat(cars.getWinnerCarNames().size()).isEqualTo(2);
                    assertThat(cars.getWinnerCarNames().get(0)).isEqualTo(cars.getCars().get(0).getName());
                    assertThat(cars.getWinnerCarNames().get(1)).isEqualTo(cars.getCars().get(2).getName());
                },
                MINIMUM_MOVE_ENERGY, MINIMUM_MOVE_ENERGY-1, MINIMUM_MOVE_ENERGY,
                MINIMUM_MOVE_ENERGY, MINIMUM_MOVE_ENERGY-1, MINIMUM_MOVE_ENERGY,
                MINIMUM_MOVE_ENERGY, MINIMUM_MOVE_ENERGY, MINIMUM_MOVE_ENERGY
        );
    }

    @Override
    public void runMain() {
        cars.race();
    }

}