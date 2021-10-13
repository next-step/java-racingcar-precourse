package racinggame.model.round;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoundTest {
	@Test
	void 라운드생성테스트() {

		int tc_1 = 1;
		int tc_2 = 2;
		int tc_3 = 3;

		Round round_1 = new Round(tc_1);
		Round round_2 = new Round(tc_2);
		Round round_3 = new Round(tc_3);

		assertEquals(tc_1, round_1.getRound());
		assertEquals(tc_2, round_2.getRound());
		assertEquals(tc_3, round_3.getRound());
	}
}
