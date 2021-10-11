package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

	@DisplayName("자동차 리스트 생성")
	@Test
	void create() {
		Cars cars = Cars.of("a,bc,def,ghij,klmno");
		assertThat(cars.getCars().size()).isEqualTo(5);
	}

}
