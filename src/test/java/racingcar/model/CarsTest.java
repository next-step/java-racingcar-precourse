package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.model.Car;
import racingcar.model.Cars;

public class CarsTest {

	@Test
	@DisplayName("Cars클래스 생성 테스트")
	public void 차_클래스_생성테스트() {
		List<Car> carList = new ArrayList<Car>();
		carList.add(new Car("페라리", 0));
		Cars cars = new Cars(carList);
		assertEquals(cars.getCars().get(0).getName(), new Car("페라리", 0).getName());
		assertEquals(cars.getCars().get(0).getPosition(), new Car("페라리", 0).getPosition());
	}
}
