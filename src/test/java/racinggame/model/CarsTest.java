package racinggame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarsTest {

	@Test
	@DisplayName("자동차들을 생성한다.")
	public void createCars() {
		Cars cars = new Cars(Arrays.asList(new Car("aaa"), new Car("bbb")));

		assertThat(cars).isEqualTo(new Cars(Arrays.asList(new Car("aaa"), new Car("bbb"))));
	}

	@ParameterizedTest
	@DisplayName("자동차이름들은 , 구분자로 분리된다. ")
	@CsvSource(value = {"aa,bb,cc;3", "aa,bb;2", "aa.bb;1", "aa:bb,cc;2"}, delimiter = ';')
	public void toSplit(String name, int nameCount) {
		Cars cars = new Cars(name);

		assertThat(cars.getCars().size()).isEqualTo(nameCount);
	}

	@Test
	@DisplayName("자동차들의 이름이 중복되면 예외가 발생한다.")
	public void checkDuplication() {
		assertThrows(IllegalArgumentException.class,
			() -> new Cars("aaa,aaa,bbb"));
	}
}