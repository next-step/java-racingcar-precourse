package racinggame.view;

import nextstep.utils.Console;

public class GameConsole {

	public String readLine(){
		return Console.readLine();
	}

	public void printLine(String message){
		System.out.println(message);
	}

	public void makeInterval() { System.out.println(""); }
}
