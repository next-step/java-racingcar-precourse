package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.common.ErrorMessage;

import static org.assertj.core.api.Assertions.*;

/**
 * CarsTest
 *
 * @author suji
 * @date 2022-04-23
 **/
class CarsTest {

    @Test
    void 자동차_목록_생성() {
        //given
        String carNames = "pobi,woni,jun";

        //when
        Cars cars = Cars.newInstance(carNames);

        //then
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void 자동차_이동_조건_발생() {
        //given
        String carNames = "pobi,woni,jun";
        Cars cars = Cars.newInstance(carNames);
        MoveNumbers moveNumbers = MoveNumbers.newInstance(4, 3, 7);

        //when
        cars.moveCars(moveNumbers);

        //then
        assertThat(cars.getIndex(0).getMovementCount()).isEqualTo(1);
        assertThat(cars.getIndex(1).getMovementCount()).isEqualTo(0);
        assertThat(cars.getIndex(2).getMovementCount()).isEqualTo(1);
    }

    @Test
    void 자동차_이동_조건_비어있을때_오류() {
        //given
        String carNames = "pobi,woni,jun";
        Cars cars = Cars.newInstance(carNames);
        MoveNumbers moveNumbers = MoveNumbers.newInstance();

        //when & then
        assertThatThrownBy(() -> {
            cars.moveCars(moveNumbers);
        }).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(ErrorMessage.ERROR_NOT_MOVE_NUMBERS);
    }

}