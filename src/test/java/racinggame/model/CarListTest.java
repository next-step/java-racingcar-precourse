package racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarListTest {

	@Test
	@DisplayName("자동차 목록 생성 검증")
	void createCarListTest() {
		List<String> carsNameList = Arrays.asList("car1", "car2", "car3");
		CarList carList = new CarList(carsNameList);
		assertThat(carList).isNotNull();
	}
}
