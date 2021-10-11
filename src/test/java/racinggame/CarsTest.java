package racinggame;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;

public class CarsTest {
	private MockedStatic<Randoms> randoms;

	@BeforeEach
	void setUp() {
		randoms = mockStatic(Randoms.class);
	}

	@AfterEach
	void finish() {
		randoms.close();
	}

	@ParameterizedTest
	@CsvSource(value = {"p,crong,honuxx,false", "p,crong,honux,true"})
	void 자동차컬렉션_내부의_자동차_이름은_5자_이하(String name1, String name2, String name3, boolean expected) {
		Cars cars = new Cars(Arrays.asList(name1, name2, name3));

		assertThat(cars.isValid()).isEqualTo(expected);
	}

	@ParameterizedTest
	@MethodSource("자동차컬렉션_전진_파라미터")
	void 자동차컬렉션_전진(int pickNumber, List<Integer> expected) {
		Cars cars = new Cars(Arrays.asList("p", "crong", "honux"));

		when(Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(pickNumber);

		cars.move();
		assertThat(cars.getDistances()).isEqualTo(expected);
	}

	static Stream<Arguments> 자동차컬렉션_전진_파라미터() {
		return Stream.of(
			Arguments.of(4, Arrays.asList(1, 1, 1)),
			Arguments.of(3, Arrays.asList(0, 0, 0))
		);
	}
}
