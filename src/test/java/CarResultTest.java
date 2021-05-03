import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.CarGroup;
import racingcar.CarResult;

public class CarResultTest {
	@Test
	void 레이싱경기_우승자_선택() {
		List<String> carNames = new ArrayList<>();
		carNames.add("benz");
		carNames.add("bmw");

		CarGroup racing = new CarGroup(carNames, "5");

		racing.getCars().get(0).forwardPosition(); // benz 이동
		racing.getCars().get(0).forwardPosition(); // benz 이동
		racing.getCars().get(0).forwardPosition(); // benz 이동

		racing.getCars().get(1).forwardPosition(); // bmw 이동

		String winner = new CarResult().selectWinners(racing);

		assertThat(winner).isEqualTo("benz,");
	}

	@Test
	void 레이싱경기_우승자_선택_동일_이동거리() {
		List<String> carNames = new ArrayList<>();
		carNames.add("benz");
		carNames.add("bmw");

		CarGroup racing = new CarGroup(carNames, "5");

		racing.getCars().get(0).forwardPosition(); // benz 이동
		racing.getCars().get(0).forwardPosition(); // benz 이동
		racing.getCars().get(0).forwardPosition(); // benz 이동

		racing.getCars().get(1).forwardPosition(); // bmw 이동
		racing.getCars().get(1).forwardPosition(); // bmw 이동
		racing.getCars().get(1).forwardPosition(); // bmw 이동

		String winner = new CarResult().selectWinners(racing);

		assertThat(winner).isEqualTo("benz,bmw,");
	}
}
