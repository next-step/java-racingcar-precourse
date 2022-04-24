package racingcar.domain.cars;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import racingcar.domain.car.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class CarsTest {

    @Test
    void ofTest() {
        Cars cars = Cars.of("테스트1,테스트2,테스트3");
        assertThat(cars).isInstanceOf(Cars.class);
    }

    @Test
    void 일급_객체_생성_체크() {
        Cars cars = Cars.of("테스트1,테스트2,테스트3");
        List<Car> carList = cars.getCars();
        assertThat(carList).hasSize(3);
    }

    @ParameterizedTest // 이름이 중복, 공백 일 때 처리 > 일단 걸러냄
    @ValueSource(strings = {"12345,aida"})
    public void 자동차들_생성_체크(String names) {
        Cars cars = Cars.of(names);
        assertThat(cars).isNotNull();
    }

    @ParameterizedTest // 이름이 중복, 공백 일 때 처리 > 일단 걸러냄
    @ValueSource(ints = {5, 9, 0})
    public void 우승자_체크(int randomNumber) {
        Cars cars = Cars.of("테스트1,테스트2,테스트3");

        MockedStatic<Randoms> mockedRandoms = mockStatic(Randoms.class);
        mockedRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(randomNumber);

        cars.moveCars();
        List<Car> win = cars.getWinner();

        mockedRandoms.close();

        assertThat(win).hasSize(3);
    }
}
