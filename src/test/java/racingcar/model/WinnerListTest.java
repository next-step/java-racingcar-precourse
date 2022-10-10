package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerListTest {
	@DisplayName("우승자 쉼표 출력 - 1명")
	@Test
	void getConcatNames_only_one() {
		List<CarName> carNameList = new ArrayList<>();
		carNameList.add(CarName.from("abc"));
		WinnerList winnerList = WinnerList.from(carNameList);
		assertThat(winnerList.getConcatNames()).isEqualTo("abc");
	}

	@DisplayName("우승자 쉼표 출력 - 2명 이상")
	@Test
	void getConcatNames_more_than_one() {
		List<CarName> carNameList = new ArrayList<>();
		carNameList.add(CarName.from("abc"));
		carNameList.add(CarName.from("def"));
		WinnerList winnerList = WinnerList.from(carNameList);
		assertThat(winnerList.getConcatNames()).isEqualTo("abc,def");
	}
}