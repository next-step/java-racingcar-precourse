package racinggame;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

	private List<Car> carList;

	@BeforeEach
	void setUp() {
		carList = Arrays.asList(new Car("페라리"), new Car("투싼"), new Car("GV80"));
	}

	@Test
	@DisplayName("자동차 경주 1회 실시")
	void carsTest() {

		//이 테스트를 검증하기 위해서 자동차 경주를 1회 실시 후, 각각의 Car 객체의 status 값을 검증해야한다.
		//하지만, 객체 그래프에서 getter 메소드를 사용하지 않고서는 테스트를 검증할 방법이 없어보인다.
		//그렇다면 테스트를 위해서 getter 메소드를 사용해서 객체 필드에 접근하는게 맞을까?
		Cars car = new Cars(carList);
		car.race(() -> true);
	}
}
