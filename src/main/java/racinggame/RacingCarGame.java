package racinggame;

import java.util.Arrays;
import java.util.List;

import nextstep.utils.Console;

public class RacingCarGame {
	public void gameStart(){
		try {
			Cars cars = new Cars(userInputCarNames(), userInputRaceNumber());
			cars.race();
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

	private String userInputRaceNumber() {
		System.out.println("시도할 회수는 몇 회인가요?");
		return Console.readLine();
	}

	private List<String> userInputCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
		return Arrays.asList(Console.readLine().split(","));
	}
}
