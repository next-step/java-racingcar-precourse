public class MoveCount {
	private int count;

	public MoveCount(CarStatus carStatus) {
		this.setCount(carStatus);
	}

	public void setCount(CarStatus carStatus) {
		if (CarStatus.READY == carStatus) {
			count = 0;
			return;
		}

		if (CarStatus.MOVE == carStatus) {
			count++;
			return;
		}
	}

	public int getCount() {
		return count;
	}
}
