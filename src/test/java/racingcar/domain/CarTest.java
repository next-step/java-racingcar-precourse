package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class CarTest {

    @Test
    public void 자동차는_random값이_4_이상_일_때_전진한다() {
        //given
        MockedStatic<Randoms> mock = mockStatic(Randoms.class);
        Car car = new Car("abcd");
        //when
        mock.when(()->Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(4,5,6);
        car.tryToGo();
        //then
        assertThat(car.getPosition()).isEqualTo(1);
        mock.close();
    }

    @Test
    public void 자동차는_random값이_4_미만_일_때_정지한다() {
        //given
        MockedStatic<Randoms> mock = mockStatic(Randoms.class);
        Car car = new Car("abcd");
        //when
        mock.when(()->Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(1,2,3);
        car.tryToGo();
        //then
        assertThat(car.getPosition()).isEqualTo(0);
        mock.close();
    }
}