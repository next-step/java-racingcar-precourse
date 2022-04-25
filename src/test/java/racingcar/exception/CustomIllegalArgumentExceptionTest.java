package racingcar.exception;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.exception.CustomIllegalArgumentException;

public class CustomIllegalArgumentExceptionTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

	@Test
	@DisplayName("Exception이 발생 한 경우 [ERROR]로 시작하는 메세지 출력")
	public void CarStatus_반환_테스트() {
		assertTrue(new CustomIllegalArgumentException("에러").getMessage().contains(ERROR_MESSAGE));
	}
}
