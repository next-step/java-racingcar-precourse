package utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ValidatorTest {

	@Test
	void isValidCarNameUserInput() {
		String normalCarNames = "pobi,crong,honux";
		String endWithComma = "pobi,crong,";
		String commaOnly = ",,";
		String startWithComma = ",pobi,crong";

		assertThat(Validator.isValidCarNameUserInput(normalCarNames)).isTrue();
		assertThat(Validator.isValidCarNameUserInput(endWithComma)).isFalse();
		assertThat(Validator.isValidCarNameUserInput(commaOnly)).isFalse();
		assertThat(Validator.isValidCarNameUserInput(startWithComma)).isFalse();
	}

	@Test
	void isValidCarName() {
		String normalName = "pobi";
		String emptyName = "";
		String spaceOnly = " ";
		String longName = "helloworld";

		assertThat(Validator.isValidCarName(normalName)).isTrue();
		assertThat(Validator.isValidCarName(emptyName)).isFalse();
		assertThat(Validator.isValidCarName(spaceOnly)).isFalse();
		assertThat(Validator.isValidCarName(longName)).isFalse();
	}

	@Test
	void isValidNumber() {
		String number = "1";
		String zero = "0";
		String nonNumber = "1o1";

		assertThat(Validator.isValidPlayNumber(number)).isTrue();
		assertThat(Validator.isValidPlayNumber(zero)).isFalse();
		assertThat(Validator.isValidPlayNumber(nonNumber)).isFalse();
	}

}
