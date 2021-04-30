
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceGameTest {
	@Test
	@DisplayName("레이싱게임테스트")
	void 레이싱게임테스트() {
		String[] strList = new String[]{"a","b","c"};
		int gameCnt = 3;
		Cars cars = new Cars(strList);
		RaceGame rg = new RaceGame(cars);
		
		assertEquals(rg.getMaxScore(rg.getRaceCars()), 0);
		rg.startGame(rg.getRaceCars());
		assertEquals(rg.printGameResult(rg.getRaceCars(), rg.getMaxScore(rg.getRaceCars())).length(), 0);
	}
}
