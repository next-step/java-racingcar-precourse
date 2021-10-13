package racinggame.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerTest {
	private static final Car TOM = new Car("tom");
	private static final Car DICK = new Car("dick");
	private static final Car HARRY = new Car("harry");
	private static final Winner WINNER = new Winner();

	@DisplayName("addWinnerInNotNull 호출시 파라미터의 Car 가 널인 경우 테스트")
	@Test
	void addWinnerInNotNull() {
		WINNER.addWinnerInNotNull(TOM);
		WINNER.addWinnerInNotNull(DICK);
		WINNER.addWinnerInNotNull(HARRY);
		WINNER.addWinnerInNotNull(null);
		assertThat(WINNER.getWinnerName()).isEqualTo("tom,dick,harry");
	}
}