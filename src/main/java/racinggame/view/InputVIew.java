package racinggame.view;

import nextstep.utils.Console;

public class InputVIew {

	public String inputCarName(){
		userOutput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		return userInput();
	}

	public String inputRaceNumber(){
		userOutput("시도할 회수는 몇 회인가요?");
		return userInput();
	}

	public String userInput(){
		return Console.readLine();
	}

	public void userOutput(String msg){
		System.out.println(msg);
	}
}
