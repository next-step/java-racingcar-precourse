package racinggame;

import java.util.ArrayList;
import java.util.List;

public class PlayResult {
	private final List<String> result;

	public PlayResult() {
		this.result = new ArrayList<>();
	}

	public void addResult(String name, int position) {
		StringBuilder sb = new StringBuilder(name + " : ");
		for (int i = 0; i < position; i++) {
			sb.append("-");
		}
		result.add(sb.toString());
	}

	public String get(int index) {
		return result.get(index);
	}

	public int size() {
		return result.size();
	}
}
