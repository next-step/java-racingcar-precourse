package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.CustomIllegalArgumentException;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RacingcarStack;
import racingcar.model.Winner;

public class Racingcar {
	public static final String INPUT_NAMES_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String INPUT_TRY_NO_MSG = "시도할 회수는 몇회인가요?";
	public static final String NAME_REGEX = ",";
	public static final int INIT_POSITION = 0;

	private RacingcarStack racingCarStack;
	private Cars cars;
	
	public Racingcar() {
		cars = new Cars(new ArrayList<Car>());
	}
	
	public void gameStart() {
		System.out.println(INPUT_NAMES_MSG);
		while(!initCars(Console.readLine())) {
		}
		System.out.println(INPUT_TRY_NO_MSG);
		while(!play(Console.readLine())) {
		}
		System.out.print(racingCarStack.toString());
		System.out.print(winner(cars).toString());
	}
	
	public Winner winner(Cars cars) {
		return new Winner(cars);
	}
	
	public boolean play(String round) {
		try {
			int roundNumber = GameUtils.strToint(round);
			validateRoundNumber(roundNumber);
			move(roundNumber);
			return true;
		}catch (CustomIllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	private void move(int roundNumber) {
		racingCarStack = new RacingcarStack();
		for(int i=0;i<roundNumber;i++) {
			cars.move();
			racingCarStack.add(cars);
		}
	}
	
	private void validateRoundNumber(int roundNumber) {
		if(roundNumber <= 0) {
			throw new CustomIllegalArgumentException("1에서 2,147,483,647범위의 숫자만 입력이 가능합니다.");
		}
	}
	
	public boolean initCars(String names) {
		try {
			cars = new Cars(arrayToList(names));
	    	return true;
		}catch (CustomIllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
    }
	
	private List<Car> arrayToList(String names){
		List<Car> list = new ArrayList<Car>();
    	for(String value : names.split(NAME_REGEX, -1)) {
    		list.add(new Car(value, INIT_POSITION));
    	}
    	return list;
	}
}
