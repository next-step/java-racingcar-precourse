package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @DisplayName("자동차 여러대 생성 테스트")
    @Test
    void carsCreateTest() {
        //given
        String[] names = new String[]{"pobi", "woni"};
        MovableStrategy movableStrategy = () -> RandomNumber.generate() >= 4;

        // when
        Cars cars = Cars.of(names, movableStrategy);

        // then
        assertThat(cars.carsSize()).isEqualTo(names.length);
    }

    @DisplayName("자동차 여러대 이동 테스트")
    @Test
    void carsMoveTest() {
        //given
        String[] names = new String[]{"pobi", "woni"};
        MovableStrategy movableStrategy = () -> RandomNumber.generate(4, 9) >= 4;
        Cars cars = Cars.of(names, movableStrategy);

        // when
        cars.move();

        // then
        assertThat(cars.totalCurPosition()).isGreaterThan(0);
    }

    @DisplayName("자동차 여러대 이동 실패 테스트")
    @Test
    void carsMoveTestFail() {
        //given
        String[] names = new String[]{"pobi", "woni"};
        MovableStrategy movableStrategy = () -> RandomNumber.generate(0, 3) >= 4;
        Cars cars = Cars.of(names, movableStrategy);

        // when
        cars.move();

        // then
        assertThat(cars.totalCurPosition()).isEqualTo(0);
    }

    @DisplayName("우승자 찾기 테스트")
    @Test
    void findWinnerTest() {
        //given
        String[] names = new String[]{"pobi", "woni"};
        MovableStrategy movableStrategy = () -> RandomNumber.generate(4, 9) >= 4;
        Cars cars = Cars.of(names, movableStrategy);

        // when
        cars.move();
        String winners = cars.findWinners(1);

        // then
        assertThat(winners.split(",").length).isEqualTo(2);
    }

}
