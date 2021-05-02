package racing.car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import racing.car.position.Position;

class CarTest {
	private CarName carName;
	private Car car;

	@BeforeEach
	void init() {
		this.carName = new CarName("pobi");
		this.car = new Car(this.carName);
	}

	@DisplayName("자동차의 이름을 반환한다.")
	@Test
	void 자동차의_이름을_반환한다() {
		CarName carName = this.car.getCarName();
		assertEquals(this.carName, carName);
	}

	@DisplayName("자동차의 처음 위치는 0 이다.")
	@Test
	void 자동차의_처음_위치는_0_이다() {
		Position position = this.car.getPosition();
		assertEquals(0, position.getVal());
	}

	@DisplayName("자동차가 전진하면 위치가 1 만큼 증가한다.")
	@Test
	void 자동차가_전진하면_위치가_1만큼_증가한다() {
		Position before = this.car.getPosition();
		this.car.forward();
		Position after = this.car.getPosition();

		assertEquals(before.getVal() + 1, after.getVal());
	}

	@DisplayName("자동차가 멈추면 위치가 그대로 유지된다.")
	@Test
	void 자동차가_멈추면_위치가_그대로_유지된다() {
		Position before = this.car.getPosition();
		this.car.stop();
		Position after = this.car.getPosition();

		assertEquals(before.getVal(), after.getVal());
	}

	@DisplayName("자동차가 주행하면 엔진에서 임의의 출력을 내어 전진하거나 멈춘다.")
	@RepeatedTest(10)
	void 자동차가_주행하면_엔진에서_임의의_출력을_내어_전진하거나_멈춘다() {
		Position before = this.car.getPosition();
		this.car.drive();
		Position after = this.car.getPosition();

		boolean isForward = before.getVal() + 1 == after.getVal();
		boolean isStop = before.getVal() == after.getVal();

		assertTrue(isForward || isStop);
	}
}
