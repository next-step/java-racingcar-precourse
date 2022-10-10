package racingcar.model;

import java.util.List;

public class WinnerList {
	private final List<CarName> carNameList;

	private WinnerList(List<CarName> carNameList) {
		this.carNameList = carNameList;
	}

	public static WinnerList from(List<CarName> carNameList) {
		return new WinnerList(carNameList);
	}

	public String getConcatNames() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(carNameList.get(0).getValue());
		for (int i = 1; i < carNameList.size(); i++) {
			stringBuilder.append(String.format(",%s", carNameList.get(i).getValue()));
		}
		return stringBuilder.toString();
	}
}
