package racinggame.model;

public class CarName {
	public static final int MAX_SIZE_CAR_NAME = 5;
	
	private String name;
	
	public CarName(String name) {
		if (name == null || "".equals(name) || name.length() > MAX_SIZE_CAR_NAME) {
			throw new IllegalArgumentException("자동차 이름은 1자이상 5자 이하여야 합니다.");
		}
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
