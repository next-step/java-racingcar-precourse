package model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import util.GameUtil;

public class CarTest {
	@Test
	@DisplayName("Car클래스의 forward함수의 테스트")
	public void initCarTest() {
		Car pobiCar = new Car("pobi");									// given, when #1
		assertThat(pobiCar.getPosition()).isEqualTo(Car.INIT_POSITION);			// then #1
	}

	@Test
	@DisplayName("Car클래스의 forward함수의 테스트")
	public void forwardTest() {
		Car pobiCar = new Car("pobi");									// given
		pobiCar.forward();														// when
		assertThat(pobiCar.getPosition()).isEqualTo(Car.INIT_POSITION + 1);		// then
	}

	@Test
	@DisplayName("콤마를 구분자로 하는 문자열로 Cars가 잘 구성되는지 테스트")
	public void createCarsTest() {
		Cars cars = new Cars(GameUtil.createCars("pobi,crong,honux"));		// given
		List<Car> carList = cars.getCarList();										// when

		// then
		assertThat(carList.size()).isEqualTo(3);
		assertThat(carList.get(0).getName()).isEqualTo("pobi");
		assertThat(carList.get(1).getName()).isEqualTo("crong");
		assertThat(carList.get(2).getName()).isEqualTo("honux");
	}
}
