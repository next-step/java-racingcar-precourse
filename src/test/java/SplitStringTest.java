
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SplitStringTest {
	@Test
	@DisplayName("스플릿테스트")
	void 스플릿테스트() {
		SplitString vis = new SplitString("a,b,c");
		SplitString vis2 = new SplitString("aa");
		assertTrue(vis.getSplitString().length == 3);
		assertTrue(vis2.getSplitString().length == 1);
	}
}
