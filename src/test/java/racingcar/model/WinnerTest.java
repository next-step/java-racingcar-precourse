package racingcar.model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerTest {
	
	@Test
	@DisplayName("Winner 클래스 객체화 테스트")
	public void Winner_생성_테스트() {
		List<Car> car = new ArrayList<>();
		car.add(new Car("페라리", 0));
		car.add(new Car("람보르기니", 2));
		car.add(new Car("포르쉐", 1));
		car.add(new Car("부가티", 2));
		car.add(new Car("벤틀리", 2));
		Cars cars = new Cars(car);
		assertEquals(new Winner(cars).toString(), "최종 우승자: 람보르기니,부가티,벤틀리");
	}
}
