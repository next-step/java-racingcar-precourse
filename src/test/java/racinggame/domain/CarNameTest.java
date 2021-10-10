package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {

	@DisplayName("자동차 이름 생성")
	@Test
	void create() {
		CarName carName = CarName.of("abcde");
		assertThat(carName.getName()).isEqualTo("abcde");
	}
}
