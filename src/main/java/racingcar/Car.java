package racingcar;

public class Car {
	private CarName carName;
	private CarDistance carDistance;

	public Car(String carName) {
		this.carName = new CarName(carName);
		this.carDistance = new CarDistance();
	}

	public String getCarName() {
		return carName.getName();
	}

	public int forward(int condition) {
		if (condition < 0 || 9 < condition) {
			throw new IllegalArgumentException("전진하는 조건은 0에서 9 사이의 값이어야 합니다.");
		}

		return 0;
	}

	public void printNameAndDistance(){
		System.out.print(getCarName() + ": ");
		for (int i = 0; i < carDistance.getDistance(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
