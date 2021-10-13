package util;

import constant.GameSettingConstant;
import constant.MsgTypes;

public class Validation {
	
	private final String CAR_NAME_SPLIT_ARGUMENT = ",";
	
	private final int GAME_TRY_MAX_COUNT = GameSettingConstant.GAME_TRY_MAX_COUNT.getSettingValue();
	
	private final int CAR_MIN_NAME_LENGTH = GameSettingConstant.CAR_MIN_NAME_LENGTH.getSettingValue();
	
	private final int CAR_MAX_NAME_LENGTH = GameSettingConstant.CAR_MAX_NAME_LENGTH.getSettingValue();
	private final int CAR_STOP_MIN_RANGE = GameSettingConstant.CAR_STOP_MIN_RANGE.getSettingValue();
	
	private final int CAR_STOP_DISTANCE_VALUE = GameSettingConstant.CAR_STOP_DISTANCE_VALUE.getSettingValue();
	private final int CAR_START_DISTANCE_VALUE = GameSettingConstant.CAR_START_DISTANCE_VALUE.getSettingValue();
	
	public boolean validationName( String carNames ) {
		boolean result = false;
		try {
			for ( String str : carNames.replaceAll(" ", "").split( CAR_NAME_SPLIT_ARGUMENT ) ) {
				result = lengthCheckToName(str);
			}
		}catch (Exception e) {
			return false;
		}
		return result;
	}
	
	private boolean lengthCheckToName(String str) throws Exception {

		if( str.length() < CAR_MIN_NAME_LENGTH || str.length() > CAR_MAX_NAME_LENGTH ){
			MsgTypes.EXCEPTION_TO_CAR_NAME.getMsg();
			throw new Exception();
		}
		return true;
	}
	
	public boolean validationCount( String inputValue ) {
		try {
			int tryCount = checkToNumber( inputValue );
			validationCountLength( tryCount );
		}catch (Exception e) {
			return false;
		}
		return true;
		
	}
	
	private Integer checkToNumber( String inputValue ) {
		try {
			return Integer.parseInt( inputValue );
		}catch ( NumberFormatException  e) {
			MsgTypes.EXCEPTION_NOT_NUMBER_TO_TRY_COUNT.getMsg();
			throw new IllegalArgumentException();
		}
	}
	
	private boolean validationCountLength(int totalCount) {
		if( totalCount == 0 || totalCount > GAME_TRY_MAX_COUNT ){
			MsgTypes.getMsg( MsgTypes.EXCEPTION_TO_PLAY_COUNT, String.valueOf( GAME_TRY_MAX_COUNT ) );
			throw new IllegalArgumentException();
		}
		return true;
	}

	public int distance(int distance) {
		
		if( distance < CAR_STOP_MIN_RANGE ) {
			return CAR_STOP_DISTANCE_VALUE;
		}
		return CAR_START_DISTANCE_VALUE;
	}
	
}
