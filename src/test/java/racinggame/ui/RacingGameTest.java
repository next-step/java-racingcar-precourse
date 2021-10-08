package racinggame.ui;

import java.io.OutputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.test.NSTest;
import nextstep.utils.Console;

class RacingGameTest extends NSTest {
	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

	private RacingGame racingGame;

	@BeforeEach
	void beforeEach (){
		super.setUp();

		racingGame = RacingGameConfig.racingGame();
	}

	@DisplayName("Input/Output 테스트")
	@Test
	void 입력_출력_테스트 (){
		assertRandomTest(() -> {
			run("pobi,woni", "1");
			verify("pobi : -", "woni : ", "최종 우승자는 pobi 입니다.");
		}, MOVING_FORWARD, STOP);
	}

	@Override
	protected void runMain() {
		racingGame.play();
	}

	static class RacingGameConfig {
		static RacingGame racingGame (){
			return new RacingGame(inputDevice(), outputDevice());
		}

		static InputDevice inputDevice (){
			return () -> Console.readLine();
		}

		static OutputDevice outputDevice (){
			return content -> System.out.println(content);
		}
	}
}