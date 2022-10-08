package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.constant.ERROR.*;

import org.junit.jupiter.api.Test;

import racingcar.domain.car.factor.CarName;

class CarNameTest {

	@Test
	public void 자동차_이름_길이_유효성_검사(){
		//given
		String str = "pooooo";
		//when
		Throwable exception = assertThrows(IllegalArgumentException.class,()->{
			CarName carName = CarName.of(str);
		});
		//then
		assertEquals(EXCESS_LENGTH,exception.getMessage());
	}

	@Test
	public void 자동차_이름_빈값_유효성_검사(){
		//given
		String str = "";

		//when
		Throwable exception = assertThrows(IllegalArgumentException.class,()->{
			CarName carName = CarName.of(str);
		});

		//then
		assertEquals(EMPTY_NAME,exception.getMessage());
	}

}
