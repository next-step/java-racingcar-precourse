package nextstep.test.utils;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.utils.Console;

public class ConsoleTest {
	@DisplayName("콘솔에 입력한 문자열을 읽을 수 있다")
	@Test
	void when_enter_string_into_console_then_check_read_string(){
		String inputData = "console input test";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
		System.setIn(inputStream);

		assertThat(Console.readLine())
			.isEqualTo(inputData);
	}
}