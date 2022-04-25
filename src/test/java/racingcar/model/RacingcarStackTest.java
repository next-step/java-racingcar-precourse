package racingcar.model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingcarStackTest {
	
	@Test
	@DisplayName("RacingcarStack 클래스 객체화 테스트")
	public void RacingcarStack_생성_테스트() {
		RacingcarStack racingcarStack = new RacingcarStack();
		List<Car> list = new ArrayList<Car>();
		racingcarStack.add(new Cars(list));	
		assertTrue(racingcarStack.toString().contains("실행결과"));
	}
}
