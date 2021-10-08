package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

	@Test
	@DisplayName("이름을 생성한다.")
	public void createName() {
		Name name = new Name("pih");

		assertThat(name).isEqualTo(new Name("pih"));
	}
}