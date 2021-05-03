package utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringUtilsTest {

	@Test
	void isValidCarNames() {
		String normalInput = "1,2,3";
		String endWithComma = "1,2,3,";
		String startWithComma = ",1,2,3";
		String noValueBetweenComma = "1,  ,3";

		assertThat(ScannerUtils.isValidCarNames(normalInput)).isTrue();
		assertThat(ScannerUtils.isValidCarNames(endWithComma)).isTrue();
		assertThat(ScannerUtils.isValidCarNames(startWithComma)).isFalse();
		assertThat(ScannerUtils.isValidCarNames(noValueBetweenComma)).isFalse();
	}

	@Test
	void isValidPlayNumber() {
		String zero = "0";
		String numberWithCharacter = "1o";
		String validNumber = "10";
		String negativeNumber = "-10";

		assertThat(ScannerUtils.isValidPlayNumber(zero)).isFalse();
		assertThat(ScannerUtils.isValidPlayNumber(numberWithCharacter)).isFalse();
		assertThat(ScannerUtils.isValidPlayNumber(validNumber)).isTrue();
		assertThat(ScannerUtils.isValidPlayNumber(negativeNumber)).isFalse();
	}
}
