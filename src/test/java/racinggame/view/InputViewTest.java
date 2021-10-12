package racinggame.view;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Console;
import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.RaceCount;

class InputViewTest {
	@Test
	@DisplayName("Console에서 입력받은 값으로 Cars를 생성한다.")
	void getCars() {
		try (final MockedStatic<Console> mockConsole = mockStatic(Console.class)) {
			mockConsole.when(Console::readLine)
				.thenReturn("이름 길이가 5를 초과한 경우", "123456", "gmoon");

			assertThat(InputView.getCars())
				.isEqualTo(new Cars(Collections.singletonList(new Car("gmoon"))));
		}
	}

	@Test
	@DisplayName("Console에서 입력받은 값으로 RaceCount를 생성한다.")
	void getRaceCount() {
		try (final MockedStatic<Console> mockConsole = mockStatic(Console.class)) {
			mockConsole.when(Console::readLine)
				.thenReturn("문자", "-1", "1");

			assertThat(InputView.getRaceCount())
				.isEqualTo(new RaceCount(1));
		}
	}
}