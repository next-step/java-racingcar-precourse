package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exception.InvalidCarNameException;

@DisplayName("경주용 자동차 목록 테스트")
class RacingCarsTest {

	@DisplayName("중복된 자동차 이름")
	@Test
	void duplicateRacingCarName() {
		/// region given
		final Throwable expectedException = new InvalidCarNameException();
		final String givenCarName = "car";
		/// endregion

		/// region when
		final Throwable actualException = assertThrows(
			expectedException.getClass(),
			() -> new RacingCars(givenCarName, givenCarName)
		);
		/// endregion

		/// region then
		assertEquals(expectedException.getClass(), actualException.getClass());
		/// endregion
	}

	@DisplayName("등록된 자동차 목록 확인")
	@Test
	void racingCars() {
		/// region given
		final String[] givenCarNames = {"car1", "car2", "car3"};
		final RacingCar[] expectedRacingCars = {
			new RacingCar(new CarName(givenCarNames[0])),
			new RacingCar(new CarName(givenCarNames[1])),
			new RacingCar(new CarName(givenCarNames[2]))
		};
		/// endregion

		/// region when
		final RacingCars actualRacingCars = new RacingCars(givenCarNames);
		/// endregion

		/// region then
		assertNotNull(actualRacingCars);
		final AtomicInteger index = new AtomicInteger();
		actualRacingCars.getRacingCars().forEach(
			racingCar -> assertEquals(expectedRacingCars[index.getAndIncrement()], racingCar)
		);
		/// endregion
	}
}