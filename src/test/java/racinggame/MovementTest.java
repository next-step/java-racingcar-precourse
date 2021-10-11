package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MovementTest {
	@Test
	void 이동_여부_테스트() {
		Movement firstMove = new Movement(4);
		Movement secondMove = new Movement(9);
		Movement thirdMove = new Movement(0);
		Movement fourthMove = new Movement(3);

		assertThat(firstMove.isMoved()).isTrue();
		assertThat(secondMove.isMoved()).isTrue();
		assertThat(thirdMove.isMoved()).isFalse();
		assertThat(fourthMove.isMoved()).isFalse();
	}
}
