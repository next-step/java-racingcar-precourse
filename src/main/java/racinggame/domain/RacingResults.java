package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingResults {
	List<String> results;

	public RacingResults() {
		results = new ArrayList<>();
	}

	public void addResult(String result) {
		results.add(result);
	}

	@Override
	public String toString() {
		return String.join("\n\n", results);
	}
}
