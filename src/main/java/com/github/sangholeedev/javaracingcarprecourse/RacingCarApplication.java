package com.github.sangholeedev.javaracingcarprecourse;

import java.util.Scanner;

import com.github.sangholeedev.javaracingcarprecourse.player.Player;
import com.github.sangholeedev.javaracingcarprecourse.racing.Race;
import com.github.sangholeedev.javaracingcarprecourse.racing.RaceCount;
import com.github.sangholeedev.javaracingcarprecourse.racing.RaceResults;

public class RacingCarApplication {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)");
		String carNames = scanner.nextLine();
		System.out.println("시도할회수는몇회인가요?");
		String count = scanner.nextLine();
		Race race = new Race(new Player(carNames),new RaceCount(Integer.parseInt(count)));
		System.out.println("실행결과");
		final RaceResults raceResults = race.raceGame();
		System.out.println(raceResults.winners().print());
	}
}
