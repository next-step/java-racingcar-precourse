import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	private static Cars classCars = new Cars(null, 10);

	@Test
	@DisplayName("자동차 이름 목록 검증")
	void isValidCarNames() {
		String[] carNamesArr1 = {"1", "2", "3", "4", "5"};
		String[] carNamesArr2 = {"", "123456"};
		assertThat(classCars.isValidCarNames(carNamesArr1)).isTrue();
		assertThat(classCars.isValidCarNames(carNamesArr2)).isFalse();
	}

}
