package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.exception.CustomIllegalArgumentException;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "테스트6자리"})
	@DisplayName("빈 값과 5자리 이상의 값의 이름 테스트")
	public void 이름_예외_테스트(String name) {
    	assertThrows(CustomIllegalArgumentException.class, () -> new Name(name));
	}
    
    @Test
    @DisplayName("1자리에서 5자리의 정상적인 이름 테스트")
    public void 이름_테스트() {
    	assertEquals(new Name("홍길동").getName(),"홍길동");
    }
}
