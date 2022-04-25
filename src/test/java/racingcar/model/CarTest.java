package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	@DisplayName("Car클래스 생성 테스트")
	public void 자동차_클래스_생성테스트() {
		Car car = new Car("홍길동", 0);
		assertEquals(car.getPosition(), new Position(0).getPosition());
		assertEquals(car.getName(), new Name("홍길동").getName());
	}
	
	@Test
	@DisplayName("차 이동 테스트")
	public void 자동차_이동_테스트() {
		Car car = new Car("홍길동", 0);
		car.move(CarStatus.STOP);
		assertEquals(car.getPosition(), new Position(0).getPosition());
		car.move(CarStatus.GO);
		assertEquals(car.getPosition(), new Position(1).getPosition());
	}
}
