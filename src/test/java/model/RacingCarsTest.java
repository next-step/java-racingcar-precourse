package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exception.InvalidCarNameException;

@DisplayName("레이싱 자동차 테스트")
class RacingCarsTest {

	@DisplayName("비어있는 자동차 이름")
	@Test
	void emptyRacingCarName() {
		/// region given
		final Throwable expectedException = new InvalidCarNameException();
		final CarName givenCarName = null;
		/// endregion

		/// region when
		final Throwable actualException = assertThrows(
			expectedException.getClass(),
			() -> new RacingCars(givenCarName)
		);
		/// endregion

		/// region then
		assertEquals(expectedException.getClass(), actualException.getClass());
		/// endregion
	}

	@DisplayName("중복된 자동차 이름")
	@Test
	void duplicateRacingCarName() {
		/// region given
		final Throwable expectedException = new InvalidCarNameException();
		final CarName givenCarName = new CarName("car");
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

	@DisplayName("자동차 등록 확인")
	@Test
	void racingCars() {
		/// region given
		final CarName[] givenCarNames = {new CarName("car1"), new CarName("car2"), new CarName("car3")};
		/// endregion

		/// region when
		final RacingCars actualRacingCars = new RacingCars(givenCarNames);
		/// endregion

		/// region then
		assertNotNull(actualRacingCars);
		final AtomicInteger index = new AtomicInteger();
		actualRacingCars.getCarNames().forEach(
			actualCarName -> assertEquals(givenCarNames[index.getAndIncrement()], actualCarName)
		);
		/// endregion
	}
}