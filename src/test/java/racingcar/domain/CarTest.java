package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class CarTest {

    private static MockedStatic<Randoms> mock;

    @BeforeAll
    static void initiateBefore() {
        mock = mockStatic(Randoms.class);
    }

    @AfterAll
    static void resetAfter() {
        mock.close();
        mock = mockStatic(Randoms.class);
    }

    @Test
    void 랜덤값이_4_이상이면_moveCount가_1_증가한다() {
        // given
        when(Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(4);
        final Car car = Car.of(CarName.of("car"));

        // when
        car.move();

        // then
        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @Test
    void 랜덤값이_3_이하이면_moveCount는_변하지_않는다() {
        // given
        when(Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(3);
        final Car car = Car.of(CarName.of("car"));

        // when
        car.move();

        // then
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

}
