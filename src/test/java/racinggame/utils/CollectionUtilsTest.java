package racinggame.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CollectionUtilsTest {
	@DisplayName("null 또는 빈 컬렉션일 경우 true를 반환한다.")
	@ParameterizedTest
	@MethodSource("provideCollectionEmptyOrNull")
	void isEmptyOrNull(Collection<Object> collection, boolean expected) {
		// given

		// when
		boolean isEmptyOrNull = CollectionUtils.isEmptyOrNull(collection);

		// then
		assertThat(isEmptyOrNull).isEqualTo(expected);
	}

	@DisplayName("컬렉션의 문자열 요소를 지정된 구분자로 합쳐 최종 문자열로 반환한다.")
	@ParameterizedTest
	@MethodSource("provideListForJoining")
	void joining(List<String> strings, String expected) {
		// given

		// when
		String actual = CollectionUtils.joining(strings);

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	@DisplayName("문자열을 리스트로 반환한다.")
	void toList() {
		// given
		String str = "gmoon,guest";

		// when
		List<String> actual = CollectionUtils.toList(str);

		// then
		assertThat(actual).containsExactly("gmoon", "guest");
	}

	static Stream<Arguments> provideCollectionEmptyOrNull() {
		return Stream.of(
			Arguments.of(null, true),
			Arguments.of(Collections.emptyList(), true),
			Arguments.of(Collections.singletonList("gmoon"), false)
		);
	}

	static Stream<Arguments> provideListForJoining() {
		return Stream.of(
			Arguments.of(Collections.emptyList(), ""),
			Arguments.of(Collections.singletonList("gmoon"), "gmoon"),
			Arguments.of(Arrays.asList("gmoon", "kim"), "gmoon,kim")
		);
	}
}