package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.constant.ERROR.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RoundTest {


	@ParameterizedTest
	@CsvSource(value = { "5"})
	public void 자동차_이동_횟수_입력(Integer count){
		//given
		//when
		Round round = Round.of(count);

		//then
		assertEquals(5,round.getRound());
	}

	@ParameterizedTest
	@CsvSource(value = { "-1","1000"})
	public void 자동차_이동_횟수_유효성_검사(Integer count){
		//given
		//when
		Throwable exception = assertThrows(IllegalArgumentException.class,()->{
			Round round = Round.of(count);
		});

		//then
		assertEquals(COUNT_MISS,exception.getMessage());
	}

	@Test
	public void 자동차_이동_문자_유효성_검사(){
		//given
		String count = "a";
		//when
		Throwable exception = assertThrows(IllegalArgumentException.class,()->{
			Round round = Round.of(count);
		});

		//then
		assertEquals(COUNT_TYPE_ERROR,exception.getMessage());
	}

}
