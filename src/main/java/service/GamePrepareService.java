package service;

import java.util.List;

import constant.GameArgumentConstant;
import constant.GameSettingConstant;
import constant.MsgTypes;
import model.Car;
import nextstep.utils.Console;
import util.Validation;


public class GamePrepareService {
	
	private List<Car> carList;
	private Validation valid;
	
	private boolean countValidResult;
	private boolean carNameValidResult;
	
	private int gameTryCount = 0;
	private int defalutDistance = GameSettingConstant.CAR_DEFAULT_DISTANCE.getSettingValue();
	private String splitArgument = GameArgumentConstant.CAR_NAME_SPLIT_ARGUMENT.getArgumentValue();
	
	public GamePrepareService( List<Car> carList, Validation valid ) {
		this.carList = carList;
		this.valid = valid;
		this.countValidResult = false;
		this.carNameValidResult = false;
	}

	public int initialize() {
		this.carNameSetting();
		this.carGameCountSetting();
		return gameTryCount;

	}

	private void carGameCountSetting() {
		String userInputValue = "";
		while( !countValidResult ){
			MsgTypes.RACING_SETTING_MSG.getMsg();
			userInputValue = Console.readLine();
			countValidResult = valid.validationCount( userInputValue );
		}
		gameTryCount = Integer.parseInt( userInputValue );
	}

	private void carNameSetting(){
		String userInputCarName = "";
		while( !carNameValidResult ){
			MsgTypes.CAR_NAME_SETTING_MSG.getMsg();
			userInputCarName = Console.readLine();
			carNameValidResult = valid.validationName( userInputCarName );
		}
		for( String carName : userInputCarName.split( splitArgument ) ) {
			carList.add( new Car( carName, defalutDistance ) );
		}
	}

}
