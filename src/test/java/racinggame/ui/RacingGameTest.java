package racinggame.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import nextstep.test.NSTest;
import nextstep.utils.Console;
import racinggame.common.ResultBoard;
import racinggame.rule.RacingRule;

class RacingGameTest extends NSTest {
	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

	private RacingGame racingGame;

	@BeforeEach
	void beforeEach() {
		super.setUp();
		racingGame = RacingGameConfig.racingGame();
	}

	@DisplayName("Input/Output 테스트")
	@Test
	void 입력_출력_테스트() {
		assertRandomTest(() -> {
			run("pobi,woni", "1");
			verify("pobi : -", "woni : ", "최종 우승자는 pobi 입니다.");
		}, MOVING_FORWARD, STOP);
	}

	@DisplayName("이름 에러 테스트")
	@Test
	void 잘못된_이름_입력_테스트() {
		assertSimpleTest(() -> {
			runNoLineFound("666666,7777777");
			verify("[ERROR] 이름을 1자 이상 5자 이하로 입력하세요");
		});
	}

	@DisplayName("이름 중복 테스트")
	@Test
	void 이름_중복_입력_테스트() {
		assertSimpleTest(() -> {
			runNoLineFound("test,test");
			verify("[ERROR] 중복된 이름을 사용할 수 없습니다.");
		});
	}

	@DisplayName("Lab는 1 이상 입력해야 한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "100"})
	void 랩_수를_입력한다(String lab) {
		assertSimpleTest(() -> {
			run("test", lab);
			verify("pobi : -", "woni : ", "최종 우승자는 pobi 입니다.");
		});
	}

	@AfterEach
	void teardown() {
		outputStandard();
	}

	@Override
	protected void runMain() {
		racingGame.play();
	}

	static class RacingGameConfig {
		static RacingGame racingGame() {
			return new RacingGame(inputDevice(), outputDevice(), circuit(), rule());
		}

		static InputDevice inputDevice() {
			return () -> Console.readLine();
		}

		static OutputDevice outputDevice() {
			return content -> System.out.println(content);
		}

		static Circuit circuit() {
			return (racingCars, labs, rule) -> {
				String result = new StringBuilder()
					.append("pobi : -\n")
					.append("woni : ")
					.append("최종 우승자는 pobi 입니다.")
					.toString();

				return new ResultBoard(result);
			};
		}

		static Rule rule() {
			return new RacingRule();
		}
	}
}