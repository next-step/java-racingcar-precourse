package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ValidationTest {

	@Test
	public void 자동차_이름은_5자_이하만_가능() {
		//given
		Car carWithFourLetterName = new Car("aaaa");
		Car carWithDiveLetterName = new Car("aaaaa");

		//when
		String fourLetterName = carWithFourLetterName.getName();
		String fiveLetterName = carWithDiveLetterName.getName();

		//then
		assertThat(fourLetterName).hasSizeLessThanOrEqualTo(5);
		assertThat(fiveLetterName).hasSizeLessThanOrEqualTo(5);
	}

	@Test
	public void 자동차_이름이_6자_이상일_경우엔_에러_발생() {
		//given
		//when
		//then
		assertThrows(IllegalArgumentException.class, () -> new Car("aaaaaa"));
		assertThrows(IllegalArgumentException.class, () -> new Car("aaaaaaa"));
	}
}
