package racinggame;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;

public class CarTest {

	@Test
	@DisplayName("자동차 생성")
	void createCar() {
		assertThat(new Car("pobi").getName()).isEqualTo("pobi");
		assertThat(new Car("crong").getName()).isEqualTo("crong");
	}

	@Test
	@DisplayName("자동차 생성 5자초과 에러 발생")
	void createCarWithLengthException() {
		assertThatThrownBy(() -> new Car("123456")).hasMessageContaining("[ERROR] 이름")
														 .isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("랜덤값이 4이상이면 전진")
	void moveForward() {
		Car car = new Car("pobi");
		car.moveOrStop(4);
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("랜덤값이 3이하면 멈춤")
	void stop() {
		Car car = new Car("pobi");
		car.moveOrStop(3);
		assertThat(car.getPosition()).isZero();
	}

	@Test
	@DisplayName("플레이(랜덤생성 후 moveOrStop) 전진 하기")
	void playMove() {
		try (MockedStatic<Randoms> mockedStatic = mockStatic(Randoms.class)) {
			mockedStatic.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
						.thenReturn(4);

			Car car = new Car("pobi");
			car.play();
			assertThat(car.getPosition()).isEqualTo(1);
		}
	}

	@Test
	@DisplayName("플레이(랜덤생성 후 moveOrStop) 멈추기 하기")
	void playStop() {
		try (MockedStatic<Randoms> mockedStatic = mockStatic(Randoms.class)) {
			mockedStatic.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
						.thenReturn(3);

			Car car = new Car("pobi");
			car.play();
			assertThat(car.getPosition()).isZero();
		}
	}
}
