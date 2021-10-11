package racinggame;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;

public class CarTest {
	private MockedStatic<Randoms> randoms;
	private CarDistance carDistance;

	@BeforeEach
	void setUp() {
		randoms = mockStatic(Randoms.class);
		carDistance = new CarDistance(0);
	}

	@AfterEach
	void finish() {
		randoms.close();
	}

	@ParameterizedTest
	@CsvSource(value = {"p,true", "crong,true", "honuxx,false"})
	void 유효한_자동차인지_확인(String name, boolean isValid) {
		CarName carName = new CarName(name);
		Car car = new Car(carName, carDistance);

		assertThat(car.isValid()).isEqualTo(isValid);
	}

	@ParameterizedTest
	@CsvSource(value = {"0,0", "3,0", "4,1", "9,1"})
	void 자동차_전진(int pickNumber, int expectedDistance) {
		Car car = new Car(new CarName("poby"), carDistance);

		when(Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(pickNumber);
		car.move();

		assertThat(car.getDistance()).isEqualTo(expectedDistance);
	}
}
