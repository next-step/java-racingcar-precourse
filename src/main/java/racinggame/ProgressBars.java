package racinggame;

import java.util.List;

public class ProgressBars {
	private final List<ProgressBar> progressBars;

	public ProgressBars(List<ProgressBar> progressBars) {
		this.progressBars = progressBars;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < progressBars.size(); i++) {
			result.append(progressBars.get(i)).append("\n");
		}

		return result.toString();
	}
}
