package racinggame.model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
	private final ArrayList<String> resultList = new ArrayList<>();

	public void addResult(List<String> result) {
		resultList.addAll(result);
	}

	public List<String> getResultList() {
		return resultList;
	}
}
