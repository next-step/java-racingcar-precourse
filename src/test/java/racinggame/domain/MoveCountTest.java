package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.exception.OutOfMoveCountException;

@DisplayName("이동횟수 도메인 Test")
class MoveCountTest {

	@Test
	@DisplayName("이동횟수 에러 Test")
	void moveCountErrorTest() {
		assertThrows(OutOfMoveCountException.class, () -> new MoveCount(0));
	}

	@Test
	@DisplayName("이동횟수 반환 테스트")
	public void getCountTest() {
		MoveCount moveCount = new MoveCount(10);
		assertEquals(10, moveCount.getCount());
	}
}