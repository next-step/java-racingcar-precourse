package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.utils.Randoms;

@DisplayName("자동차 이동 객체 Test")
class CarMoveTest {

	@Test
	@DisplayName("자동차 이동 Test")
	void checkMoveTest() {
		CarMove carMove = new CarMove();
		int randomMove = Randoms.pickNumberInRange(0, 9);
		assertThat(randomMove >= 4).isEqualTo(true);
		assertThat(randomMove < 4).isEqualTo(false);
	}
}