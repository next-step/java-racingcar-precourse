package racinggame.model;

public class RacingCarName {
	private String name;
	
	public RacingCarName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public Boolean isValid() {
		if(name == null) {
			return false;
		}
		if(name.length() > 5) {
			return false;
		}
		return true;
	}
}
