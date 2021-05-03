package com.woowacourse.racingcar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class RacingCarGame {
	private static int NAME_MAX_LENGTH = 5;
	private static int MOVE_MIN_VALUE = 4;
	
	class RacingCar implements Comparable<RacingCar>{
		String name;
		int moveCnt;
		
		RacingCar(String name) {
			this.name = name;
		}
		
		private String getCarName() {
			return this.name;
		}

		private int getMoveCnt() {
			return this.moveCnt;
		}
		
		private void setCarName(String name) {
			this.name = name;
		}
		
		private void setMoveCnt() {
			this.moveCnt += 1;
		}

		@Override
		public int compareTo(RacingCar o) {
			return this.moveCnt - o.moveCnt;
		}
	}
	
	public static void main(String[] args) {
		RacingCarGame racingCarGame = new RacingCarGame();
		
		racingCarGame.startGame();
	}

	public void startGame() {
		String inputCarNames = inputCarNames();
		int inputLoopCnt = Integer.parseInt(inputLoopCount());
		
		String[] carNames = inputCarNames.split(",");
		Map<String, RacingCar> racingCars = new LinkedHashMap<String, RacingCarGame.RacingCar>();
		
		for (int i = 0; i < carNames.length; i++) {
			racingCars.put(carNames[i], new RacingCar(carNames[i]));
		}
		
		for (int i = 0; i < inputLoopCnt; i++) {
			moveCars(racingCars);
		}
	}
	
	public String inputCarNames() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String carNames = "";
		
		try {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
			carNames = br.readLine();
			
			if (!validateCarName(carNames)) {
				carNames = inputCarNames();
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return carNames;
	}
	
	public boolean validateCarName(String carName) {
		carName = carName.trim();
		
		if (carName.length() == 0) {
			System.out.println("자동차 이름은 필수값입니다.");
			return false;
		}
		
		String[] carNames = carName.split("\\s*,\\s*");
		
		for (int i = 0; i < carNames.length; i++) {
			if (carNames[i].length() > NAME_MAX_LENGTH) {
				System.out.println("자동차 이름은 최대5자리까지 허용됩니다.");
				return false;
			}
		}
		
		return true;
	}
	
	public String inputLoopCount() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String loopCnt = "";
		
		try {
			System.out.println("시도할 횟수는 몇회인가요?");
			loopCnt = br.readLine();
			
			if (!validateNumber(loopCnt)) {
				System.out.println("숫자만 입력하세요.");
				loopCnt = inputLoopCount();
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return loopCnt;
	}
	
	public Boolean validateNumber(String number) {
		try {
			Integer.parseInt(number);
			
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
	public void moveCars(Map<String, RacingCar> cars) {
		for (String carName : cars.keySet()) {
			RacingCar car = cars.get(carName);
			
			moveCar(car);
		}
	}
	
	public void moveCar(RacingCar car) {
		Random random = new Random();
		int randomNum = (int)(random.nextInt(9)) + 1;
		
		if (randomNum >= MOVE_MIN_VALUE) {
			car.setMoveCnt();
			return;
		}
	}
}
