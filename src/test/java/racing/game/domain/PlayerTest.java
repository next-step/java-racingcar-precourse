package racing.game.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayerTest {
	static Player player;

	@BeforeAll
	static void setUp() {
		player = new Player();
	}

	@Test
	@DisplayName(",로 이름 구분 테스트")
	public void splitNamesText() {
		String inputText = "pobi,crong,honux";

		ReceivedNames receivedNames = new ReceivedNames(inputText);
		receivedNames.convertList();
		List<String> names = receivedNames.getSplittedTextList();

		assertThat(names.size()).isEqualTo(3);
		assertThat(names.get(0)).isEqualTo("pobi");
		assertThat(names.get(1)).isEqualTo("crong");
		assertThat(names.get(2)).isEqualTo("honux");
	}

	@ParameterizedTest
	@CsvSource(value = {"over5Character,false", "다섯자이상입니다,false", "apple,true", "다섯자글자,true", "네자글자,true"})
	@DisplayName("5자 이하 유효성 검사")
	public void under5Character(String eachName, boolean expected) {

		assertThat(Validator.isUnder5Character(eachName)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"일이,false", "12,true", "0,true", "-12,false", "12일이,false", "일12,false"})
	@DisplayName("횟수 입력 유효성 검증")
	public void validateNumber(String inputNumberString, boolean expected) {
		assertThat(Validator.isNumeric(inputNumberString)).isEqualTo(expected);
	}
}