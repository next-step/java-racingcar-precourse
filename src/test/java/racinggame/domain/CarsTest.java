package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

	private Cars cars;

	@BeforeEach
	void setUp() {
		cars = Cars.of("a,bc,def,ghij,klmno");
	}

	@DisplayName("자동차 리스트 생성")
	@Test
	void create() {
		assertThat(cars.getCars().size()).isEqualTo(5);
	}

	@DisplayName("position 최대값 확인")
	@Test
	void getMaxPosition_test() {
		cars.getCars().get(0).move(4);
		cars.getCars().get(0).move(5);
		cars.getCars().get(1).move(6);
		assertThat(cars.getMaxPosition()).isEqualTo(2);
	}
}
