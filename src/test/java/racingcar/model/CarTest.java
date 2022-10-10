package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import racingcar.code.ErrorCode;
import racingcar.exception.CarException;


@DisplayName("Car 테스트")
public class CarTest {

	@DisplayName("Car Java Bean 생성 테스트")
	@Test
	void createJavabeanTest() {
		// given
		String name = "name";
		int forward = 5;
		int stop = 5;
		// when
		Car car = new Car(name, forward, stop);
		// then
		assertAll(
			() -> assertThat(car).isInstanceOf(Car.class),
			() -> assertThat(car.getForward()).isEqualTo(forward),
			() -> assertThat(car.getStop()).isEqualTo(stop),
			() -> assertThat(car.getName()).isEqualTo(name)
		);
	}

	@DisplayName("Car Builder 생성 테스트")
	@Test
	void createBuilderTest() {
		// given
		String name = "name";
		int forward = 5;
		int stop = 0;
		// when
		Car car = new Car.CarBuilder()
			.name(name)
			.forward(forward)
			.stop(stop)
			.build();
		// then
		assertAll(
			() -> assertThat(car).isInstanceOf(Car.class),
			() -> assertThat(car.getName()).isEqualTo(name),
			() -> assertThat(car.getForward()).isEqualTo(forward),
			() -> assertThat(car.getStop()).isEqualTo(stop)
		);
	}

	@DisplayName("Car name 최대길이 5자 제한 예외처리 테스트")
	@Test
	void exceptionOverNameRangeTest() {
		// given
		String name = "nameOver";
		assertThatThrownBy(
			() -> {
				// when
				new Car.CarBuilder().name(name).build();
			}
			// then
		).isInstanceOf(CarException.class)
			.hasMessageContaining(ErrorCode.INVALID_NAME_RANGE_ERROR.getMessage());
	}

	@DisplayName("Car name 최대길이 5자 제한 경계값 테스트")
	@ParameterizedTest(name = "{index} ==> name {0}")
	@ValueSource(strings = {"1", "", "ekek", "asvsdw"})
	void createCarNameLengthTest(String name) {
		try {
			// given // when
			Car car = new Car.CarBuilder().name(name).build();
			assertThat(car.getName()).isEqualTo(name);
		} catch (Throwable throwable) {
			// then
			assertThat(throwable).isInstanceOf(CarException.class);
			assertThat(throwable).hasMessageContaining(ErrorCode.INVALID_NAME_RANGE_ERROR.getMessage());
		}

	}

	@DisplayName("Car getOutputMove() 함수 테스트")
	@ParameterizedTest(name = "{index} ==> name {0}, forward {1}, wantResult {2}")
	@CsvSource(value = {
		"tusan, 5, 'tusan : -----'",
		"ace, 3, 'ace : ---'",
		"benz, 0, 'benz : '"
	})
	void createOutputMoveStringTest(String name, int forward, String wantResult) {
		// given
		Car car = new Car.CarBuilder().name(name).forward(forward).build();
		// when
		String outputMoveString = car.getOutputMove();
		// then
		assertThat(outputMoveString).isEqualTo(wantResult);
	}

	@DisplayName("Car 정수값을 입력하여 자동차를 전진, 정지 값을 갱신하는 테스트")
	@Test
	void moveCarUsingInteger() {
		// given
		Car car = new Car.CarBuilder().name("mini").build();
		// when
		car.moveCarInteger(5);
		car.moveCarInteger(3);
		// then
		assertAll(
			() -> assertThat(car.getForward()).isEqualTo(1),
			() -> assertThat(car.getStop()).isEqualTo(1),
			() -> assertThat(car.getOutputMove()).isEqualTo("mini : -")
		);
	}

	@DisplayName("Car Randoms를 사용하여 자동차를 전진, 정지 값을 갱신하는 테스트")
	@ParameterizedTest(name = "{index} ==> randomNumber {0}, stop {1}, forward {2}")
	@CsvSource(value = {
		"3, 1, 0",
		"5, 0, 1",
		"2, 1, 0",
		"9, 0, 1"
	})
	void moveCarUsingRandoms(int randomNumber, int stop, int forward) {
		// given
		Car car = new Car.CarBuilder().name("mini").build();
		MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class);
		// when
		mockRandoms.when(
			() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
			.thenReturn(randomNumber);
		car.moveCar();
		mockRandoms.close();
		// then
		assertThat(car.getStop()).isEqualTo(stop);
		assertThat(car.getForward()).isEqualTo(forward);
	}
}