
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidInputStringTest {
	@Test
	@DisplayName("스플릿테스트")
	void 스플릿테스트() {
		ValidInputString vis = new ValidInputString("a,b,c");
		ValidInputString vis2 = new ValidInputString("aa");
		assertTrue(vis.splitInputString().length == 3);
		assertTrue(vis2.splitInputString().length == 1);
	}
}
