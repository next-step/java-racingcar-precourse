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

	@Test
	public void 자동차_이동_조건은_0에서_9_사이의_값(){
		//given
		Car car = new Car("aaaa");

		//when
		int travelDistancefor0 = car.forward(0);
		int travelDistancefor9 = car.forward(9);

		//then
		assertThat(travelDistancefor0).isExactlyInstanceOf(Integer.class);
		assertThat(travelDistancefor9).isExactlyInstanceOf(Integer.class);
	}

	@Test
	public void 자동차_이동_조건이_0에서_9_사이_값이_아니면_에러_발생(){
		//given
		Car car = new Car("aaaa");

		//when
		assertThrows(IllegalArgumentException.class, () -> car.forward(-1));
		assertThrows(IllegalArgumentException.class, () -> car.forward(10));
	}
}
