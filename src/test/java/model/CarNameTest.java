package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import exception.InvalidCarNameException;

@DisplayName("자동차 이름 테스트")
class CarNameTest {

	@DisplayName("자동차 이름 유효성검사")
	@NullAndEmptySource
	@ValueSource(strings = {"car123"})
	@ParameterizedTest()
	void invalidCarName(final String givenCarName) {
		/// region given
		final Throwable expectedException = new InvalidCarNameException();
		/// endregion

		/// region when
		final Throwable actualThrowable = assertThrows(
			expectedException.getClass(),
			() -> new CarName(givenCarName)
		);
		/// endregion

		/// region then
		assertEquals(expectedException.getClass(), actualThrowable.getClass());
		/// endregion
	}

	@DisplayName("자동차 이름 확인")
	@Test
	void carName() {
		/// region given
		final String givenCarName = "car";
		final CarName expectedCarName = new CarName(givenCarName);
		/// endregion

		/// region when
		final CarName actualCarName = new CarName(givenCarName);
		/// endregion

		/// region then
		assertNotNull(actualCarName);
		assertEquals(expectedCarName, actualCarName);
		/// endregion
	}
}