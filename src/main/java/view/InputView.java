package view;

import nextstep.utils.*;

public class InputView {
	
	public String Input_CarName() {
		System.out.println("경주마 이름을 입력해 주세요(이름은 쉼표,로 구분)");
		return Console.readLine();
	}
	
	public String Input_game_chance() {
		System.out.println("게임 시도 횟수를 알려주세요");
		return Console.readLine();
		
	}
	

}
