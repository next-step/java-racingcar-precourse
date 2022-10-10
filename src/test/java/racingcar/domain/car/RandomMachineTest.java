package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.constant.SETTING.*;

import org.junit.jupiter.api.Test;

class RandomMachineTest {

	@Test
	public void 랜덤_숫자_추출_후진_확인(){
		//given
		RandomMachine randomMachine = new RandomMachine(0,3);
		//when
		int stop = randomMachine.goAndStop();
		//then
		assertEquals(STOP,stop);
	}

	@Test
	public void 랜덤_숫자_추출_전진_확인(){
		//given
		RandomMachine randomMachine = new RandomMachine(4,9);
		//when
		int go = randomMachine.goAndStop();
		//then
		assertEquals(GO,go);
	}

}
