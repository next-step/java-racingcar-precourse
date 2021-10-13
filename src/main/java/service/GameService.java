package service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import constant.GameSettingConstant;
import constant.MsgTypes;
import model.Car;
import model.GameServiceModel;
import nextstep.utils.Randoms;
import util.Validation;


public class GameService {
	
	private Validation valid;
	
	private List<Car> carList;
	private int playCount;
	
	private int RANDOM_MIN_VALUE = GameSettingConstant.CAR_MIN_NAME_LENGTH.getSettingValue();
	private int RANDOM_MAX_VALUE = GameSettingConstant.CAR_MAX_NAME_LENGTH.getSettingValue();
	
	public GameService( List<Car> carList, Validation valid ) {
		this.carList = carList;
		this.valid = valid;
	}
	
	public void racingStart( int playCount ) {
		this.playCount = playCount;
		MsgTypes.RACING_START_MSG.getMsg();
		playToRacing();
	}

	private void playToRacing() {
		
		for( int i = 0; i < playCount; i++ ) {
			tentativeResults();
		}
		
	}
	
	private void tentativeResults(){
		for( Car car : carList ) {
			int distance = Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE);
			distance = valid.distance(distance);
			car.getTentativeResult( distance );
		}
		System.out.println("");
    }
	
    public void getGameResult(){
    	GameServiceModel gameServiceModel = new GameServiceModel( carList );
    	gameServiceModel.getWinner();
    }
    
    
}
