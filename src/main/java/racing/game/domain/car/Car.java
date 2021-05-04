package racing.game.domain.car;

public class Car {
	private String carName;
	private int position;
	private int currentLapCount;
	private boolean currentMoveState;

	public Car(String carName) {
		this.carName = carName;
		position = 0;
	}

	public Car(String carName, int position) {
		this.carName = carName;
		this.position = position;
	}

	public void setInitPosition() {
		position = 0;
	}

	public String getCarName() {
		return carName;
	}

	public int getPosition() {
		return position;
	}

	private boolean isMove() {    //테스트 위해 상태 저장, 상태 저장할 필요 있을까?
		return Accelerator.isMove();
	}

	public void addCurrentLapCount() {
		currentLapCount++;
	}

	public void movePosition() {
		addCurrentLapCount();
		if (isMove()) {
			position++;
		}
	}

	public boolean getCurrentMoveState() {
		return currentMoveState;
	}

	public String getResultGraph() {
		return getResultGraph(position);
	}

	public String getResultGraph(int position) {
		StringBuffer resultGraph = new StringBuffer();
		resultGraph.append(carName).append(":").append(getPositionGraph(this.position));
		getPositionGraph(position);
		return resultGraph.toString();
	}

	private String getPositionGraph(int position) {
		StringBuffer resultGraph = new StringBuffer();
		for (int i = 0; i < position; i++) {
			resultGraph.append("-");
		}
		return resultGraph.toString();
	}
}
