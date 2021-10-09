package racinggame.view;

import racinggame.manage.*;
import nextstep.utils.Console;

import racinggame.Racing_game;

public class InputView {
	
	private static final String ERROR_MESSAGE = "[ERROR]";
	
	public static Racing_game Input_CarName() {
		System.out.println("경주마 이름을 입력해 주세요(이름은 쉼표,로 구분)");
		String str=Console.readLine();
		while(!Vaildating.game_playing(str)) {
			printErrMsg();
			str=Console.readLine();
		}
		
		return new Racing_game(str);
	}
	
	public static String Input_game_chance() {
		System.out.println("게임 시도 횟수를 알려주세요");
		String str = Console.readLine();
		
		while(!Vaildating.IsNum(str)) {
			printErrMsg();
			str=Console.readLine();
		}
		
		return str;
	}
	
	public static void printErrMsg() {
		System.out.println(ERROR_MESSAGE);
	}

}
