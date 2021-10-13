package racinggame.model;

import static nextstep.utils.Constants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Winner {
	private final List<String> winners;

	public Winner() {
		winners = new ArrayList<>();
	}

	public void addWinnerInNotNull(final Car car) {
		if (Objects.nonNull(car)) {
			winners.add(car.getCarName());
		}
	}

	public String getWinnerName() {
		return String.join(DELIMITER_COMMA, winners);
	}
}
