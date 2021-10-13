package racinggame.model.car;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.model.Car;
import racinggame.model.RacingParticipant;

import java.util.ArrayList;
import java.util.List;

public class RacingParticipantTest {
	@Test
	@DisplayName("레이싱참가자 생성 검증")
	void 레이싱참가(){

		// given
		List<Car> carTest = new ArrayList<Car>();
		Car tc_1 = new Car("tc_1");
		Car tc_2 = new Car("tc_2");
		carTest.add(tc_1);
		carTest.add(tc_2);

		// when
		RacingParticipant rp = new RacingParticipant(carTest);

		// then
		Assertions.assertEquals(carTest, rp.getCars());
	}
}
