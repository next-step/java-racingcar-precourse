package racinggame.dto;

public class InitRacingGameDto {
	private Integer runNumber;
	private String carNamesStr;
	
	public Integer getRunNumber() {
		return runNumber;
	}

	public void setRunNumber(Integer runNumber) {
		this.runNumber = runNumber;
	}

	public String getCarNamesStr() {
		return carNamesStr;
	}

	public void setCarNamesStr(String carNamesStr) {
		this.carNamesStr = carNamesStr;
	} 
}
