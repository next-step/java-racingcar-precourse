import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RaceGame {
	private static final String printStr = "-";
	private Cars cars;
	
	public RaceGame(Cars cars) {
		this.cars = cars;
	}
	
	public Cars getRaceCars() {
		return cars;
	}
	
	public void startNthGames(Cars cars, int playCnt) {
		if(playCnt < 1) {
			return;
		}
		for(int i = 0; i < playCnt; i++) {
			startGame(cars);
		}
	}
	
	public void startGame(Cars cars) {
		for(Car car : cars.getCarList()) {
			car.addScore();
			System.out.println(car.getCarName() + ":" + 
				String.join("", Collections.nCopies(car.getCarScore(), printStr)));
		}
		this.cars = cars;
	}
	
	public String printGameResult(Cars cars, int maxScore) {
		List<String> resList = new ArrayList<>();
		String resString = "";
		for(Car car : cars.getCarList()) {
			if(maxScore == car.getCarScore()) {
				resList.add(car.getCarName());
			}
		}
		resString = resList.toString();
		return resString.substring(1,resString.length()-1);
	}
	
	public int getMaxScore(Cars cars) {
		int maxScore = 0;
		for(Car car : cars.getCarList()) {
			maxScore = Math.max(maxScore, car.getCarScore());
		}
		return maxScore;
	}
	
}
