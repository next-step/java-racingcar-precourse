package racing.game.domain;

public class Car {
	String carName;
	boolean currentMoveState;
	int position;

	public Car(String carName) {
		this.carName = carName;
		position = 0;
	}

	public String getCarName() {
		return carName;
	}

	public int getPosition() {
		return position;
	}

	private boolean isMove() {	//테스트 위해 상태 저장, 상태 저장할 필요 있을까?
		currentMoveState = Accelerator.isMove();
		return currentMoveState;
	}

	public void movePosition() {
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
		resultGraph.append(carName).append(":");
		for (int i = 0; i < position; i++) {
			resultGraph.append("-");
		}
		return resultGraph.toString();
	}
}
