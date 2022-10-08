package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.constant.ERROR.*;

import org.junit.jupiter.api.Test;

class RoundTest {

	@Test
	public void 자동차_이동_횟수_유효성_검사(){
		//given
		Integer count = -1;
		//when
		Throwable exception = assertThrows(IllegalArgumentException.class,()->{
			Round round = Round.of(count);
		});

		//then
		assertEquals(COUNT_MISS,exception.getMessage());
	}

}
