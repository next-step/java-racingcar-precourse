package racinggame;

public class CarName {
	private final int MAX_LENGTH = 5;

	private final String name;

	public CarName(String name) {
		if(name.length() > MAX_LENGTH){
			throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
		}
		this.name = name;
	}
}
