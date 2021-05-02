import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.CarGroup;

public class CarGroupTest {
	@Test
	@DisplayName("레이싱 경주 자동차 그룹 생성 검증")
	void 자동차_isEmpty() {
		List<String> carNames = new ArrayList<>();

		assertThatIllegalArgumentException().isThrownBy(() -> {
			new CarGroup(carNames, "1");
		}).withMessage("생성할 자동차 사이즈가 %s 입니다.", carNames.size())
			.withMessageContaining("게임을 진행할 자동차가 없습니다.");
	}

	@Test
	@DisplayName("레이싱 경주 자동차 그룹 생성 검증")
	void 게임_진행_횟수() {
		List<String> carNames = new ArrayList<>();
		carNames.add("benz");
		carNames.add("bmw");

		String gameCount = "111a";

		assertThatIllegalArgumentException().isThrownBy(() -> {
			new CarGroup(carNames, gameCount);
		}).withMessage("입력한 게임 진행횟수는 %s", gameCount)
			.withMessageContaining("게임 진행 횟수를 입력하세요.");
	}
}
