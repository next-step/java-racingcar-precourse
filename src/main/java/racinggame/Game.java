package racinggame;

import java.util.NoSuchElementException;

import nextstep.utils.Console;
import racinggame.model.Cars;

/**
 * @auhor Kim JeongJin <kingroma92@gmail.com>
 * @version 1.0
 * @since 1.0
 * */
public class Game {
	public Cars cars = new Cars();
	
	private int playCount = 0;
	
	public void init() throws NoSuchElementException, IllegalArgumentException, Exception {
//		System.out.println("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		addCars(Console.readLine());
		
//		System.out.println("시도할 회수는 몇회인가요?");
		setPlayCount(Console.readLine());
	}
	
	/**
	 * 자동차 이름 입력 
	 * 
	 * @param line 자동차 이름 입력
	 * */
	private void addCars(String line) throws IllegalArgumentException {
		if (line == null || line.isEmpty()) {
			throw new IllegalArgumentException("[ERROR]");
		}

		this.cars.addCars(line.split(","));
	}

	/**
	 * 랜덤 플레이 카운트 입력
	 * 
	 * @param line 플레이 카운트 입력
	 * */
	private void setPlayCount(String line) {
		if (line == null || line.isEmpty()) {
			throw new IllegalArgumentException("[ERROR]");
		}

		try {
			playCount = Integer.parseInt(line);
		} catch (Exception e) {
			throw new IllegalArgumentException("[ERROR]");
		}
	}
	
	public void play() {
		for (int i = 0; i < playCount; i++) {
			cars.moveOrStop();
			cars.printPosition();
			System.out.println();
		}
	}
	
	public void finish() {
		cars.printWinner();
	}
}
