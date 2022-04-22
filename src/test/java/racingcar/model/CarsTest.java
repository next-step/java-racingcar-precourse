package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

@DisplayName("자동차 일급객체 단위 테스트")
class CarsTest {

    @DisplayName("인스턴스 생성 테스트")
    @Test
    void fromTest() {

        //given //when
        Cars cars = Cars.from("name1,name2,name3");

        //then
        assertThat(cars).isInstanceOf(Cars.class);
    }

    @DisplayName("일급객체 멤버 변수 테스트")
    @Test
    void getCarsTest() {

        //given
        Cars cars = Cars.from("name1,name2,name3");

        //when
        List<Car> carList = cars.getCars();

        //then
        assertThat(carList).hasSize(3);
    }

    @DisplayName("자동차 전진 및 멈춤 후 우승자 반환 테스트")
    @ParameterizedTest
    @ValueSource(ints = {5, 6})
    void getMaxPositionCars(int randomNumber) {

        //given
        Cars cars = Cars.from("name1,name2,name3");
        MockedStatic<Randoms> mockRandom = mockStatic(Randoms.class);

        //when
        mockRandom.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(randomNumber);
        cars.moveOrStopCars();
        List<Car> maxPositionCars = cars.getMaxPositionCars();
        mockRandom.close();

        //then
        assertThat(maxPositionCars).hasSize(3);
    }

}
