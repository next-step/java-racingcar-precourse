package racinggame.view;

import racinggame.domain.Name;
import racinggame.domain.Position;
import racinggame.utils.Message;

public class GameView {

	public void print(Message message) {
		System.out.println(message.getMessage());
	}

	public void print(Name name, Position position) {
		System.out.println(name.getValue() + " : " + positionToString(position.getValue()));
	}

	private String positionToString(int position) {
		String positionToString = "";
		for (int i = 0; i < position; i++) {
			positionToString += "-";
		}
		return positionToString;
	}

}
