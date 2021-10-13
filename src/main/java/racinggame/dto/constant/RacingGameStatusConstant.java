package racinggame.dto.constant;

public enum RacingGameStatusConstant {
	ERROR("ERROR"),
	INITED("INITED"),
	RUNNING("RUNNING"),
	FINISH("FINISH");
	
	private final String code; 
	
	RacingGameStatusConstant(String code){
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
