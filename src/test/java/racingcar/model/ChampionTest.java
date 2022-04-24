package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChampionTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        Names names = Names.valueOf("mond,apple,choco,pizza");
        cars = Cars.create(names);
        for (int count = 0; count < 100; count++) {
            cars.move();
        }
    }

    @Test
    @DisplayName("가장 멀리 움직인 거리를 구한다")
    void findMaxPosition() {
        Position position= Champion.getMaxPosition(cars);
        assertThat(position.getValue()).isNotNegative();
    }

    @Test
    @DisplayName("가장 멀리 움직인 자동차(들)을 구한다")
    void findMaxPositionCars() {
        Cars result = Champion.pickParticularPositionCar(cars);
        assertThat(result.getCars()).hasSizeGreaterThan(0);
    }

    @Test
    @DisplayName("우승자를 뽑고 발표한다")
    void pickAndAnnounceChampion() {
        Champion champion = Champion.pick(cars);
        assertThat(champion.announce().getCars()).hasSizeGreaterThan(0);
    }
}
