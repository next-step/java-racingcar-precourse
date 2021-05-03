package car;

public class CarIndex {

	private int index = 0;

	public void addIndex(CarStatus status) {
		if (status.equals(CarStatus.FORWARD)) {
			this.index++;
		}
	}

	public int getIndex() {
		return this.index;
	}

}
