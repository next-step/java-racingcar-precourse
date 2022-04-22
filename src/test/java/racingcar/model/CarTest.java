package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

@DisplayName("자동차 단위 테스트")
class CarTest {
    @DisplayName("자동차 인스턴스 생성 테스트")
    @Test
    void newCarTest() {

        //given //when
        Car car = new Car("name");

        //then
        assertThat(car).isInstanceOf(Car.class);
    }

    @DisplayName("자동차 인스턴스 위치 초기값 테스트")
    @Test
    void getPositionTest() {

        //given
        Car car = new Car("name");

        //when
        int position = car.getPosition();

        //then
        assertThat(position).isZero();
    }

    @DisplayName("자동차 이름 가져오기 테스트")
    @Test
    void getCarNameTest() {

        //given
        String name = "name";
        Car car = new Car("name");

        //when
        String result = car.getCarName();

        //then
        assertThat(result).isEqualTo(name);
    }

    @DisplayName("랜덤값을 이용하여 자동차가 전진 또는 멈춤 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1, 0", "2, 0", "3, 0", "4, 1", "5, 1", "6, 1", "7, 1", "8, 1", "9, 1"})
    void moveOrStopTest(int randomNumber, int position) {

        //given
        Car car = new Car("name");
        MockedStatic<Randoms> mockRandom = mockStatic(Randoms.class);

        //when
        mockRandom.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(randomNumber);
        car.moveOrStop();
        mockRandom.close();

        //then
        assertThat(car.getPosition()).isEqualTo(position);
    }
}
