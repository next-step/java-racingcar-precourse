package racingcar.domain;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class RefereeTest {
    @Test
    @DisplayName("우승자가 한명인 경우 확인")
    void winner_1() {
        MockedStatic<Randoms> mockUtils = mockStatic(Randoms.class);
        //given
        Car car = new Car("haha");
        given(Randoms.pickNumberInRange(anyInt(), anyInt())).willReturn(3);
        car.play();
        Car car2 = new Car("hoho");
        given(Randoms.pickNumberInRange(anyInt(), anyInt())).willReturn(9);
        car2.play();
        List<Car> carList = new ArrayList<>();
        carList.add(car);
        carList.add(car2);
        Referee referee = new Referee(new CarList(carList));

        //when
        CarList winnerList = referee.getWinnerList();

        //then
        Assertions.assertThat(winnerList.getCarList()).contains(car2);
        mockUtils.close();
    }

    @Test
    @DisplayName("우승자가 여러명인 경우 결과 확인")
    void winner_several() {
        MockedStatic<Randoms> mockUtils = mockStatic(Randoms.class);
        //given
        given(Randoms.pickNumberInRange(anyInt(), anyInt())).willReturn(9);
        Car car = new Car("haha");
        car.play();
        Car car2 = new Car("hoho");
        car2.play();
        List<Car> carList = new ArrayList<>();
        carList.add(car);
        carList.add(car2);
        Referee referee = new Referee(new CarList(carList));

        //when
        CarList winnerList = referee.getWinnerList();

        //then
        Assertions.assertThat(winnerList.getCarList()).contains(car, car2);
        mockUtils.close();
    }
}
