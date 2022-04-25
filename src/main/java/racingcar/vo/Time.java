package racingcar.vo;

public class Time {

	private int value;

	public Time(int value) {
		this.value = value;
	}

	public Time() {
		this.value = 0;
	}

	public void go() {
		this.value++;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
