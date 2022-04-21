package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    Cars cars;
    PickNumberStrategy exactNumberStrategy = () -> 4;
    @BeforeEach
    void setUp() {
        cars = new Cars();
        cars.lineUpCars(Arrays.asList("pobi", "honux"));
    }

    @Test
    @DisplayName("초기화가 전달받은 이름들로 잘 생성됐는지 확인")
    void 초기화_테스트() {
        assertThat(cars.toString())
                .contains("pobi :")
                .contains("honux :");
    }

    @Test
    @DisplayName("레이싱을 한 턴 실행했을 때, 값이 바뀌는지 확인")
    void 랜덤_인수가_적용되는지_확인() {
        cars.changeStrategy(exactNumberStrategy);
        cars.processRound();
        assertThat(cars.toString())
                .contains("pobi : -")
                .contains("honux : -");
    }

    @Test
    @DisplayName("우승자를 정상적으로 출력하는지")
    void 우승자_확인() {
        cars.changeStrategy(exactNumberStrategy);
        cars.processRound();
        assertThat(cars.findWinners()).isEqualTo("pobi,honux");
    }
}