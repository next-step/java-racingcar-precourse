package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import constant.MsgTypes;

public class GameServiceModel {
	
	private Map<String,Integer> racingCars;
	private List<String> winnerList;
	
	public GameServiceModel(List<Car> carList) {
		
		this.winnerList = new ArrayList<>();
		this.racingCars = new LinkedHashMap<>();
		for( Car car : carList ) {
			this.racingCars.put( car.getCarName() , car.getDistance());
		}
	}
	
	public void getWinner() {
		int maxValue = Collections.max(racingCars.values());
        for(Map.Entry<String, Integer> entry : racingCars.entrySet()) {
            setWinner(entry, maxValue);
        }
        String winnerStr = StringUtils.join( winnerList,"," );
        MsgTypes.getMsg( MsgTypes.WINNER_FORMAT_MSG, winnerStr );
    }
    

    private void setWinner(Map.Entry<String, Integer> entry, int maxValue) {
        if( entry.getValue() == maxValue ) {
        	winnerList.add( entry.getKey() );
        }
	}
	
}
