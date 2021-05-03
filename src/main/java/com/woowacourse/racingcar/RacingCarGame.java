package com.woowacourse.racingcar;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RacingCarGame {
	private static int NAME_MAX_LENGTH = 5;

	public static void main(String[] args) {
		RacingCarGame racingCarGame = new RacingCarGame();
		
		racingCarGame.startGame();
	}

	public void startGame() {
		String inputCarNames = inputCarNames();
		int inputLoopCnt = Integer.parseInt(inputLoopCount());
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
}
