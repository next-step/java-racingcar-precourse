package racinggame.dto;

import racinggame.domain.*;

import java.util.ArrayList;
import java.util.List;

public class ResultDto {
	private static final CharSequence DISTANCE_STRING = "-";
	private final Histories histories;
	private final Winners winners;
	private final StringBuilder message;

	private ResultDto(Game game) {
		histories = game.getHistories();
		winners = Winners.of(game);
		message = new StringBuilder();
		setMessage();
	}

	public static ResultDto of(Game game) {
		return new ResultDto(game);
	}

	private void setMessage() {
		message.append("실행 결과\n");
		for (History history : histories) {
			setMessage(history);
			message.append("\n");
		}
		List<String> names = new ArrayList<>();
		for (Car winner : winners) {
			names.add(winner.getName().getValue());
		}
		message.append("최종 우승자는 ").append(String.join(",", names)).append(" 입니다.");
	}

	private void setMessage(History history) {
		for (Name name : history.keySet()) {
			message.append(name.getValue()).append(" : ");
			setMessage(history.get(name));
			message.append("\n");
		}
	}

	private void setMessage(Distance distance) {
		message.append(new String(new char[distance.getLength()]).replace("\0", DISTANCE_STRING));
	}

	public String getMessage() {
		return message.toString();
	}
}
