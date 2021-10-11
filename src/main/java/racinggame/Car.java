package racinggame;

public class Car {

	private final CarName name;
	private int position;

	public Car(String name) {
		this.name = new CarName(name);
		this.position = 0;
	}

	public void race(int number) {
		if(isMove(number)){
			this.position += 1;
		}
	}

	private boolean isMove(int number) {
		return number > 3 && number < 10;
	}

	public int getPosition() {
		return this.position;
	}
}
