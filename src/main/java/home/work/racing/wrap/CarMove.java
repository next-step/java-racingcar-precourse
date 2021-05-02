package home.work.racing.wrap;

import lombok.Getter;

@Getter
public class CarMove {
	
	private int move = 0;
	
	public void moving() {
		this.move++;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof CarMove) {
			return this.move == CarMove.class.cast(obj).getMove();
		}
		return false;
	}
}