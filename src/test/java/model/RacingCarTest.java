package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exception.InvalidCarNameException;

@DisplayName("경주용 자동차 테스트")
class RacingCarTest {

	@DisplayName("비어있는 경주용 자동차 이름")
	@Test
	void invalidRacingCarName() {
		/// region given
		final Throwable expectedException = new InvalidCarNameException();
		final CarName givenCarName = null;
		/// endregion

		/// region when
		final Throwable actualException = assertThrows(
			expectedException.getClass(),
			() -> new RacingCar(givenCarName)
		);
		/// endregion

		/// region then
		assertEquals(expectedException.getClass(), actualException.getClass());
		/// endregion
	}

	@DisplayName("생성된 경주용 자동차 확인")
	@Test
	void racingCar() {
		/// region given
		final CarName givenCarName = new CarName("car");
		final RacingCar expectedRacingCar = new RacingCar(givenCarName);
		/// endregion

		/// region when
		final RacingCar actualRacingCar = new RacingCar(givenCarName);
		/// endregion

		/// region then
		assertNotNull(actualRacingCar);
		assertEquals(expectedRacingCar, actualRacingCar);
		/// endregion
	}
}