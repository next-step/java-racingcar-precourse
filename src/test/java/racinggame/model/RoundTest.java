package racinggame.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RoundTest {
	Round round;
	@BeforeEach
	void setUp() {
		round = new Round(2);
	}

	@Test
	@DisplayName("라운드가 진행할 때마다 1씩 감소되지는 테스트")
	void nextRound() {
		round.nextRound();
		assertThat(round.getRound()).isEqualTo(1);
	}

	@Test
	@DisplayName("라운드가 감소되서 0이되면 마지막 라운드인지 테스트")
	void isFinalRound() {
		round.nextRound();
		round.nextRound();
		assertThat(round.isFinalRound()).isTrue();
	}
}
