package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarsTest {
	@Test
	void 콤마로_구분하여_자동차들_생성() {
		assertThat(new Cars("bus,texi,suv"))
				.isInstanceOf(Cars.class);
	}
}
