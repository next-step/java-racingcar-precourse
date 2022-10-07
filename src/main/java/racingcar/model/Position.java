package racingcar.model;

public class Position {

	private int position;

	public Position(final int position) {
		if (position < 0) {
			throw new IllegalArgumentException("[ERROR] 차량 위치는 0부터 시작합니다."); //todo [ERROR]를 하드코딩 하는게 맘에 안든다.
		}
		this.position = position;
	}

	public String toString() {
		String str = "";
		for (int i = 0; i < position; i++) {
			str += "-";
		}
		return str;
	}


	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
}
