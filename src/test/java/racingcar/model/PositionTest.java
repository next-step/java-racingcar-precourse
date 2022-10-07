package racingcar.model;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

	@Test
	@DisplayName("포지션 toString 테스트")
	public void test1() throws Exception {
		Position position = new Position(3);
		System.out.println(position.toString());

		Assertions.assertThat(position.toString()).isEqualTo("---");
	}


}