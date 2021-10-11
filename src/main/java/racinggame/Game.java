package racinggame;

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
	
	public void init() {
//		System.out.println("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		addCars(Console.readLine());
		
//		System.out.println("시도할 회수는 몇회인가요?");
		setPlayCount(Console.readLine());
	}
	
	private void addCars(String line) throws IllegalArgumentException {
		if (line == null || line.isEmpty()) {
			throw new IllegalArgumentException("[ERROR]");
		}

		this.cars.addCars(line.split(","));
	}

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
		
	}
	
	public void finish() {
		
	}
}
