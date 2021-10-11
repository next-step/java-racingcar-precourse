package racinggame.controller;

import nextstep.utils.Console;
import racinggame.model.Cars;
import racinggame.view.RacingGameView;

public class RacingGameController {
	private RacingGameView view = new RacingGameView();
	
	/**
	 * 프로그램 시작
	 */
	public void run() {
		gameStart();
	}
	
	/**
	 * 레이싱게임 시작(단판)
	 */
	private void gameStart() {
		Cars cars = initCars();
		System.out.println("생성결과 \n"+cars.getStatus());
		
	}

	/**
	 * 자동차들 생성 초기작업
	 * @return 생성 완료된 자동차들
	 */
	private Cars initCars() {
		Cars cars = null;
		do {
			cars = makeCars();
		} while(cars == null);
		
		return cars;
	}

	/**
	 * 사용자로부터 자동차 이름을 입력받아서 자동차들 생성
	 * @return 생성된 자동차들(오류날경우 null)
	 */
	private Cars makeCars() {
		Cars cars = null;
		try {
			cars = new Cars(inputCarNames());
		} catch(IllegalArgumentException ie) {
			view.printlnErrorInputCarNames(ie);
		}
		return cars;
	}
	
	/**
	 * 자동차 이름 입력
	 * @return 입력한 값
	 */
	private String inputCarNames() {
		view.printlnInputCarNames();
		return Console.readLine();
	}
}
