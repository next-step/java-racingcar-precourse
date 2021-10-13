package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 레이싱의 결과를 저장하는 콜렉션
 *
 * @author Lee JungHo <jparangdev@gmail.com>
 * @version 1.0
 * @since 1.0
 */
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
