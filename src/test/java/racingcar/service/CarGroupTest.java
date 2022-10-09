package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarGroupTest {

    private CarGroup carGroup;

    @BeforeEach
    void setUp() {
        carGroup = CarGroup.fromNames("a,b,c");
    }

    @Test
    void 차이름들을_입력받아_객체생성() {
        assertThat(carGroup).isNotNull();
        assertThat(carGroup.getCarCount()).isEqualTo(3);
    }

    @Test
    void 차이름들중_동일한이름있을경우_에러() {
        String names = "a,a,c";
        assertThatThrownBy(() -> CarGroup.fromNames(names))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 차량들_n번이동() {
        carGroup.raceByTimes(0);
        carGroup.raceByTimes(10);
    }

    @Test
    void n번이동후_우승자들이름_리턴() {
        carGroup.raceByTimes(4);
        String winnerNames = carGroup.getWinners();

        assertThat(winnerNames).containsAnyOf("a", "b", "c");
    }
}
