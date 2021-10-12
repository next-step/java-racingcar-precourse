package racinggame.rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WinnerNames {
	private final List<String> names = new ArrayList<>();

	/**
	 * 우승자를 우승자 리스트에 추가한다.
	 * @param name
	 */
	public void addName(String name) {
		if ("".equals(name)) {
			return;
		}
		names.add(name);
	}

	/**
	 * 우승자를 delimiter 로 구별해 문자열로 반환한다.
	 * @param delimiter
	 * @return String
	 */
	public String getNamesWithDelimiter(String delimiter) {
		Integer lastIndex = lastIndexOf();

		if (lastIndex == null) {
			return "";
		}

		return nameBuilder(lastIndex, delimiter);
	}

	private String nameBuilder(int lastIndex, String delimiter) {
		StringBuilder nameBuilder = new StringBuilder();

		for (int index = 0; index < lastIndex; ++index) {
			nameBuilder.append(names.get(index)).append(delimiter);
		}
		nameBuilder.append(names.get(lastIndex));

		return nameBuilder.toString();
	}

	private Integer lastIndexOf() {
		if (names.size() == 0) {
			return null;
		}
		return names.size() - 1;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		WinnerNames that = (WinnerNames)o;
		return names.equals(that.names);
	}

	@Override
	public int hashCode() {
		return Objects.hash(names);
	}
}
