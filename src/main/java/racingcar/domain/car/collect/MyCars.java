package racingcar.domain.car.collect;

import static racingcar.constant.SETTING.*;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.car.CarName;
import racingcar.domain.car.MyCar;

public class MyCars {

	private final List<MyCar> myCars;

	public MyCars(List<MyCar> myCars) {
		this.myCars = new ArrayList(myCars);
	}

	public Integer  currentDistance(int round){
		Integer sumDistance = 0;
		for(int i=0;i<=round;i++){
			sumDistance+= distance(i);
		}
		return sumDistance;
	}

	public Integer lastDistance(){
		Integer sumDistance = 0;
		for(int i=0;i<myCars.size();i++){
			sumDistance+= distance(i);
		}
		return sumDistance;
	}

	public Integer distance(int round) {
		return myCarsByRound(round).getDistance();
	}

	public MyCar myCarsByRound(int round) {
		return myCars.get(round);
	}

	public CarName playerCarName(){
		return myCarsByRound(FIRST_INDEX).getCarName();
	}

	@Override
	public String toString() {
		return "MyCars{" +
			"myCars=" + myCars +
			'}';
	}
}
