package racinggame.model;

public class RacingCar {
	private String name;
	private Integer location;
	
	public RacingCar(String name) {
		this.name = name;
		this.location = 0;
	}
	
	public void moveFront() {
		this.location++;
	}

	public String getName() {
		return name;
	}
	
	public Integer getLocation() {
		return location;
	}
}
