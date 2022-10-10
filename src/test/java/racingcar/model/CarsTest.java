package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import racingcar.code.ErrorCode;
import racingcar.exception.CarException;


@DisplayName("Cars 테스트")
public class CarsTest {

	@InjectMocks
	private static Cars.CarsBuilder carsBuilder;

	@BeforeEach
	void setup() {
		carsBuilder = new Cars.CarsBuilder();
	}

	@DisplayName("Cars Builder 생성 테스트")
	@Test
	void createBuilderTest() {
		// given // when
		Cars cars = new Cars.CarsBuilder().build();
		// then
		assertAll(
			() -> assertThat(cars).isInstanceOf(Cars.class),
			() -> assertThat(cars.getCarList()).isInstanceOf(List.class)
		);
	}

	@DisplayName("Cars 자동차 이름 input 예외 처리 테스트")
	@Test
	void exceptionCarListInputName() {
		// given // when
		String input = "car1,car2,eweqwe";
		//then
		assertThatThrownBy(() -> {
			carsBuilder.convertInputToCarList(input);
		}).isInstanceOf(CarException.class)
			.hasMessageContaining(new CarException(ErrorCode.INVALID_NAME_RANGE_ERROR.getMessage()).getMessage());
	}

	@DisplayName("Cars 자동차 이름으로 Cars 생성 테스트")
	@Test
	void createCarListInputName() {
		// given
		String input = "car1,car2,car3";
		// when
		List<Car> carList = carsBuilder.convertInputToCarList(input);
		// then
		assertAll(
			() -> assertThat(carList).isInstanceOf(List.class),
			() -> assertThat(carList.size()).isEqualTo(3),
			() -> assertThat(carList).isNotEmpty(),
			() -> assertThat(carList.get(0).getName()).isEqualTo("car1"),
			() -> assertThat(carList.get(1).getName()).isEqualTo("car2"),
			() -> assertThat(carList.get(2).getName()).isEqualTo("car3"),
			() -> assertThat(carList.get(0).getForward()).isZero(),
			() -> assertThat(carList.get(0).getStop()).isZero()
		);
	}

	@DisplayName("Cars Randoms를 사용하여 자동차를 전진, 정지 값을 갱신하는 테스트")
	@ParameterizedTest(name = "{index} ==> randomNumber {0}, stop {1}, forward {2}")
	@CsvSource(value = {
		"1, 0, 1",
		"4, 1, 0",
		"0, 0, 1",
		"9, 1, 0",
	})
	void moveCarsTest(int randomNumber, int forward, int stop) {
		// given
		Cars cars = new Cars.CarsBuilder().carList("a,b,c").build();
		MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class);
		// when
		mockRandoms.when(
			() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
			.thenReturn(randomNumber);
		cars.moveCars();
		mockRandoms.close();
		// then
		assertAll(
			() -> assertThat(cars.getCarList().get(0).getForward()).isEqualTo(forward),
			() -> assertThat(cars.getCarList().get(0).getStop()).isEqualTo(stop),
			() -> assertThat(cars.getCarList().get(1).getForward()).isEqualTo(forward),
			() -> assertThat(cars.getCarList().get(1).getStop()).isEqualTo(stop),
			() -> assertThat(cars.getCarList().get(2).getForward()).isEqualTo(forward),
			() -> assertThat(cars.getCarList().get(2).getStop()).isEqualTo(stop)
		);
	}
}