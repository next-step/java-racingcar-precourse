public class Car {
	private String name;
	private CarStatus carStatus;
	private MoveCount moveCount;

	public Car(String name) {
		this.name = name;
		this.carStatus = CarStatus.READY;
		this.moveCount = new MoveCount(this.carStatus);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCarStatus(CarStatus carStatus) {
		// 이미 GOAL 상태이면 더 이상 상태 변화 x
		if (CarStatus.GOAL == this.carStatus) {
			return;
		}

		moveCount.setCount(carStatus);
		if (this.moveCount.getCount() == Game.getGoal()) {
			this.carStatus = CarStatus.GOAL;
		}
	}

	public void setMoveCount(MoveCount moveCount) {
		this.moveCount = moveCount;
	}

	public String getName() {
		return name;
	}

	public CarStatus getCarStatus() {
		return carStatus;
	}

	public MoveCount getMoveCount() {
		return moveCount;
	}
}
