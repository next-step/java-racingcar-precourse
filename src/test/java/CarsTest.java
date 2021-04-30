
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
	@Test
	@DisplayName("자동차목록테스트")
	void 자동차목록테스트() {
		String[] strList = new String[]{"a","b","c"};
		assertEquals(new Cars(strList).getCarList().size(), strList.length);
	}
}
