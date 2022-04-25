package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.exception.CustomIllegalArgumentException;

public class PositionTest {
	
    @ParameterizedTest
    @ValueSource(ints = {-1})
	@DisplayName("음수값을 입력한 위치값 테스트")
	public void 위치값_예외_테스트(int position) {
    	assertThrows(CustomIllegalArgumentException.class, () -> new Position(position));
	}
    
    @Test
	@DisplayName("정상적인 0이상의 정수값을 입력한 위치값 테스트")
	public void 위치값_테스트() {
    	assertEquals(new Position(0).getPosition(), 0);
	}
    
    @Test
    @DisplayName("위치이동 테스트")
    public void 위치값_이동_테스트() {
    	Position position = new Position(0);
    	position.move(CarStatus.STOP);
    	assertEquals(position.getPosition(), 0);

    	position.move(CarStatus.GO);
    	assertEquals(position.getPosition(), 1);
    }
}
