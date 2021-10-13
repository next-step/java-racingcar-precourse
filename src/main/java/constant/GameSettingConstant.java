package constant;

public enum GameSettingConstant {

	CAR_DEFAULT_DISTANCE( 0 ),
	
	CAR_MIN_NAME_LENGTH( 1 ),
	CAR_MAX_NAME_LENGTH( 5 ),
	
	GAME_TRY_MAX_COUNT( 10 ),
	
	RANDOM_MIN_VALUE( 1 ),
	RANDOM_MAX_VALUE( 9 ),
	
	CAR_STOP_MIN_RANGE( 4 ),
	
	CAR_STOP_DISTANCE_VALUE( 0 ),
	CAR_START_DISTANCE_VALUE( 1 ),
	;

    private int constantValue;

    private GameSettingConstant(int constantValue) {
        this.constantValue = constantValue;
    }

	public int getSettingValue() {
		return constantValue;
	}
    
}
