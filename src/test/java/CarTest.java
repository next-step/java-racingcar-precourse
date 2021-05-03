import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	void 자동차_이름은_5글자_이하() {
		Car car1 = new Car("car1");
		assertThat(car1.hasPassedNameRule(car1.getName())).isTrue();

		Car car2 = new Car("5글자를넘자");
		assertThat(car2.hasPassedNameRule(car2.getName())).isFalse();
	}

	@Test
	void 위치값은_0이상() {
		Car car = new Car("car");
		assertThat(car.getLocation() >= 0).isTrue();
	}

	@Test
	void 위치값_한_칸_전진() {
		Car car = new Car("car");
		assertThat(car.getLocation()).isZero();

		car.go();
		assertThat(car.getLocation()).isEqualTo(1);
	}
}
