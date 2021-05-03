package car;

public class MovePosition {
	public static final int FORWARD_CONDITION = 4;

	private int point = 0;

	public void addForwardPoint() {
		this.point++;
	}

	public int getPoint() {
		return this.point;
	}

}
