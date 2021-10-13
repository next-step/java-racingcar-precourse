package racinggame.view.constant;

public enum  MessageConstant {
	INIT_GAME_ERROR_MESSAGE("[ERROR] 게임시작중 에러가 발생하였습니다.\n"),
	INPUT_CAR_NAMES_MESSAGE("경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)\n"),
	INPUT_RUN_NUMBER_MESSAGE("시도할회수는몇회인가요?\n"),
	RUN_RACING_GAME_MESSAGE("실행 결과\n");
	
	private final String message; 
	
	MessageConstant(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
