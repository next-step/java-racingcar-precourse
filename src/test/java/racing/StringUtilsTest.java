package racing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

	@DisplayName("입력한 문자를 n번 만큼 반복한 문자열로 만든다.")
	@Test
	void 입력한_문자를_n번_만큼_반복한_문자열로_만든다() {
		String expected = "-----";
		String actual = StringUtils.repeat("-", 5);

		assertEquals(expected, actual);
	}
}