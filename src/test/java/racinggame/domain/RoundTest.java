package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RoundTest {


	@Test
	void 몇번을_이동할지_입력() {

		Round round = new Round(3);

		assertThat(round).isNotNull();
	}
	
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:false"}, delimiter = ':')
	void 라운드_진행_및_종료여부(int value, boolean exceptEnd){
		Round round = new Round(value);
		
		round.nextRound();

		assertThat(round.isEnd()).isEqualTo(exceptEnd);
	}
}