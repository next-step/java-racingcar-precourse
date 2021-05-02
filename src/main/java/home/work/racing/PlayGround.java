package home.work.racing;

import java.util.Scanner;

public class PlayGround {
	
	public static void main(String[] args) {
		CommandLineInterface cli = new CommandLineInterface(new Scanner(System.in));
		new RacingGame(cli).play();
	}

}