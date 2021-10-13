package racinggame.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarNameTest {

	@DisplayName("CarName 의 생성과, 이름이 잘 할당되었는지 테스트")
	@ParameterizedTest
	@CsvSource(value = {"tom", "dick", "harry"})
	void getName(final String name) {
		CarName carName = new CarName(name);
		assertThat(carName.getName()).isEqualTo(name);
	}
}