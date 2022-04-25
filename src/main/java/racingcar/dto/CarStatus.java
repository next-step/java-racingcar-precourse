package racingcar.dto;

public class CarStatus {
	private String name;
	private int position;

	public CarStatus(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public static CarStatus of(String name, int position) {
		return new CarStatus(name, position);
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
