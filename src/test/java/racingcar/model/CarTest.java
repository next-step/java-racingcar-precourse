package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	@DisplayName("한칸 앞으로 갔을떄 제대로 갔는지 테스트")
	public void positionForward() throws Exception {
		Car car = new Car("kim", 3);
		System.out.println(car.getPosition());

		car.moveForward();
		System.out.println(car.getPosition());

		Position expectedPosition = new Position(4);
		Assertions.assertThat(car.getPosition().toString())
			.isEqualTo(expectedPosition.toString());
	}


}