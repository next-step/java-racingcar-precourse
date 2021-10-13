package racinggame.strategy;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import nextstep.utils.Randoms;

public class MovingStrategyTest {
	@DisplayName("항상 움직일 수 없다")
	@Test
	void not_move_always(){
		MovingStrategy strategy = new NoMovingStrategy();

		assertThat(strategy.isMoveable()).isFalse();
	}

	@DisplayName("항상 움직일 수 있다")
	@Test
	void move_always(){
		MovingStrategy strategy = new DefaultMovingStrategy();

		assertThat(strategy.isMoveable()).isTrue();
	}

	@DisplayName("4가 주어지면 움직일 수 있다")
	@Test
	void given_4_then_move(){
		try (final MockedStatic<Randoms> mockRandoms = Mockito.mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(4);
			MovingStrategy strategy = new RandomMovingStrategy();

			assertThat(strategy.isMoveable()).isTrue();
		}
	}

	@DisplayName("3이 주어지면 움직일 수 없다")
	@Test
	void given_3_then_not_move(){
		try (final MockedStatic<Randoms> mockRandoms = Mockito.mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(3);
			MovingStrategy strategy = new RandomMovingStrategy();

			assertThat(strategy.isMoveable()).isFalse();
		}
	}
}