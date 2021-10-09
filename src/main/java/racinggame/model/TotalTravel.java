package racinggame.model;

public class TotalTravel {
	private int totalTravel;

	public void moveForward() {
		totalTravel++;
	}
	
	public int get() {
		return totalTravel;
	}
}
