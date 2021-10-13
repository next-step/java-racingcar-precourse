package racinggame;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RoundsTest {
	@BeforeEach
    void beforeEach() {}

    @Test
    @DisplayName("생성실패")
    void fail() {
    	checkException("012");
		checkException("1f2");
    }
    
    void checkException(final String round) {
    	assertThrows(IllegalArgumentException.class, () -> {
    		new Rounds(round);
    	});
    }
    
    @Test
    @DisplayName("생성성공")
    void success() {
    	assertDoesNotThrow(() -> {
    		new Rounds("12");
    	});
    }
}
