package racinggame;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CarNamesTest {
	@Test
	void 자동자들의_이름은_중복되면_안된다() {
		List<CarName> carNameList = makeCarNameListOf("carA", "carB", "carB");
		assertThatThrownBy(() -> new CarNames(carNameList))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("중복된 이름은 사용할 수 없습니다");
	}

	List<CarName> makeCarNameListOf(String... names) {
		List<CarName> carNameList = new ArrayList<>();
		for (String name : names) {
			carNameList.add(new CarName(name));
		}

		return carNameList;
	}
}
