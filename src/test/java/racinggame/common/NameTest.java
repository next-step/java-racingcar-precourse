package racinggame.common;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.exception.InvalidNameException;

class NameTest {

	@DisplayName("입력 성공")
	@ParameterizedTest
	@ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
	void createName (String name){
		assertThat(new Name(name).valueOf()).isEqualTo(name);
	}

	@DisplayName("에러발생 - 제한 길이 미만, 초과")
	@ParameterizedTest
	@ValueSource(strings = {"", "abcdef", "abcdefgh"})
	void createNameFail (String name){
		assertThatThrownBy(() -> new Name(name).valueOf())
			.isInstanceOf(InvalidNameException.class)
			.hasMessage("[ERROR] 이름을 1자 이상 5자 이하로 입력하세요");
	}

}