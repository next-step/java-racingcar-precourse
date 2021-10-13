package racinggame.model;

public class RacingCar {
	private RacingCarName racingCarName;
	private Integer location;
	
	public RacingCar(RacingCarName racingCarName) {
		this.racingCarName = racingCarName;
		this.location = 0;
	}
	
	public void moveFront() {
		this.location++;
	}

	public RacingCarName getRacingCarName() {
		return racingCarName;
	}
	
	public Integer getLocation() {
		return location;
	}
	
	public Boolean isValid() {
		if(racingCarName == null) {
			return false;
		}
		if(!racingCarName.isValid()) {
			return false;
		}
		return true;
	}
}
