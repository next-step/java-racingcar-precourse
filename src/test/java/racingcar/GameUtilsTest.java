package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import racingcar.exception.CustomIllegalArgumentException;
import racingcar.model.CarStatus;

public class GameUtilsTest {
	@DisplayName("0에서 9까지 랜덤값 반환 테스트, 1000번")
	@RepeatedTest(value=1000)
	public void 랜덤값_반환_테스트() {
		int pickNumber = GameUtils.pickNumberInRange();
		assertTrue(pickNumber>=0 && pickNumber<=9);
	}
	
	@Test
	@DisplayName("0에서 9까지 범위가 벗어난 값을 입력하여 에러 테스트")
	public void CarStatus_반환_예외_테스트() {
		assertThrows(CustomIllegalArgumentException.class, () -> GameUtils.getCarStatus(-1));
		assertThrows(CustomIllegalArgumentException.class, () -> GameUtils.getCarStatus(11));
	}

	@Test
	@DisplayName("0에서 9까지 값을 입력하여 CarStatus반환")
	public void CarStatus_반환_테스트() {
		for(int i=0;i<4;i++) {
			assertEquals(GameUtils.getCarStatus(i), CarStatus.STOP);
		}
		for(int i=4;i<10;i++) {
			assertEquals(GameUtils.getCarStatus(i), CarStatus.GO);
		}
	}
}
