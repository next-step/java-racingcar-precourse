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
	@MethodSource("자동차컬렉션_컴마를_포함한_문자열로_생성_테스트_파라미터")
	void 자동차컬렉션_컴마를_포함한_문자열로_생성(String namesWithComma, List<String> expectedNames) {
		Cars cars = new Cars(namesWithComma);

		for (int i = 0; i < cars.getCars().size(); ++i) {
			assertThat(cars.getCars().get(i).getName()).isEqualTo(expectedNames.get(i));
		}
	}

	static Stream<Arguments> 자동차컬렉션_컴마를_포함한_문자열로_생성_테스트_파라미터() {
		return Stream.of(
			Arguments.of("p,crong,honuxx", Arrays.asList("p", "crong", "honuxx")),
			Arguments.of("honux,pobi,super", Arrays.asList("honux", "pobi", "super"))
		);
	}

	@ParameterizedTest
	@CsvSource(value = {"p,crong,honuxx,false", "p,crong,honux,true"})
	void 자동차컬렉션_내부의_자동차_이름은_5자_이하(String name1, String name2, String name3, boolean expected) {
		Cars cars = new Cars(Arrays.asList(name1, name2, name3));

		assertThat(cars.isValid()).isEqualTo(expected);
	}

	@ParameterizedTest
	@MethodSource("자동차컬렉션_전진_파라미터")
	void 자동차컬렉션_전진(int pickNumber, List<Car> expected) {
		Cars cars = new Cars(
			Arrays.asList(expected.get(0).getName(), expected.get(1).getName(), expected.get(2).getName())
		);

		when(Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(pickNumber);

		cars.move();
		for (int i = 0; i < cars.getCars().size(); ++i) {
			assertThat(cars.getCars().get(i).getName()).isEqualTo(expected.get(i).getName());
			assertThat(cars.getCars().get(i).getDistance()).isEqualTo(expected.get(i).getDistance());
		}
	}

	static Stream<Arguments> 자동차컬렉션_전진_파라미터() {
		List<String> names = Arrays.asList("p", "crong", "honux");
		return Stream.of(
			Arguments.of(4,
				Arrays.asList(
					new Car(names.get(0), 1),
					new Car(names.get(1), 1),
					new Car(names.get(2), 1)
				)
			),
			Arguments.of(3,
				Arrays.asList(
					new Car(names.get(0), 0),
					new Car(names.get(1), 0),
					new Car(names.get(2), 0)
				)
			)
		);
	}

	@ParameterizedTest
	@MethodSource("자동차컬렉션_우승자_테스트_파라미터")
	void 자동차컬렉션_우승자_테스트(List<String> names, String winners, Integer randomResult1, Integer... randomResults2) {
		Cars cars = new Cars(names);

		when(Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(randomResult1, randomResults2);

		cars.move();
		assertThat(cars.getWinners()).isEqualTo(winners);
	}

	static Stream<Arguments> 자동차컬렉션_우승자_테스트_파라미터() {
		return Stream.of(
			Arguments.of(Arrays.asList("pobi", "crong", "honux"), "pobi", 4, new Integer[] {3, 3}),
			Arguments.of(Arrays.asList("pobi", "crong", "honux"), "pobi,crong", 4, new Integer[] {4, 3}),
			Arguments.of(Arrays.asList("pobi", "crong", "honux"), "pobi,crong,honux", 4, new Integer[] {4, 4})
		);
	}
}
