package test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import app.Car;
import app.Game;

@TestInstance(Lifecycle.PER_CLASS)
class GameTest extends Game {

	@BeforeAll
	public void setting() {
		Car c1 = new Car("dong1", 4, false);
		Car c2 = new Car("dong2", 5, false);
		Car c3 = new Car("dong3", 6, false);
		Car c4 = new Car("dong4", 3, false);
		ArrayList<Car> param = new ArrayList<Car>();
		param.add(c1);
		param.add(c2);
		param.add(c3);
		param.add(c4);
		list = param;
	}

	
	@Test
	void testCalculateWinners() {
		ArrayList<Car> candi = new ArrayList<Car>();
		assertThat(new Car("dong3", 6, false)).isIn(calculateWinners(6));
	}

	@Test
	void testCalculateMaximum() {
		assertThat(6).isEqualTo(calculateMaximum());
	}

}
