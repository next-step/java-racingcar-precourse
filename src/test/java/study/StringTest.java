package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringTest {
	@Test
	void split() {
		String str = "";
		String[] actual = str.split(",");
		assertThat(actual).hasSize(1);
	}

	@Test
	void split_only_comma() {
		String str = ",,,,";
		String[] actual = str.split(",");
		assertThat(actual).hasSize(0);
	}

	@ParameterizedTest
	@CsvSource(value = {"123,456,789,:3", ",abc,dev,:3"}, delimiter = ':')
	void split_with_comma(String str, int expected) {
		String[] actual = str.split(",");
		assertThat(actual).hasSize(expected);
	}
}
