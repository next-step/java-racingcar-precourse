package racingcar.view;

import java.util.StringJoiner;

import racingcar.constants.RacingCarMessage;
import racingcar.domain.RacingCars;

public class RacingCarGameOut {

	public static void printResult(RacingCars cars) {
		System.out.println(RacingCarMessage.MESSAGE_RESULT);
	}

	public static void printRoundResult(RacingCars cars) {
		String[][] locationList = cars.getCurrentLocation();
		for(String[] location : locationList) {
			printLocation(location);
		}
		System.out.print("\n");
	}

	private static void printLocation(String[] location) {
		System.out.println(location[0] + RacingCarMessage.CAR_NAME_COLON + printLocation(location[1]));
	}

	private static String printLocation(String location) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Integer.parseInt(location); i++) {
			sb.append(RacingCarMessage.CAR_NAME_HYPHEN);
		}
		return sb.toString();
	}

	private static String arrayToString(String[] winnerCars) {
		StringJoiner sj = new StringJoiner(RacingCarMessage.CAR_NAME_COMMA);
		for (String name : winnerCars) {
			sj.add(name);
		}
		return sj.toString();
	}

	public static void getGameResult(RacingCars cars) {
		String[] winnerCars = cars.getWinnerCars();
		System.out.print(RacingCarMessage.MESSAGE_WINNER+ arrayToString(winnerCars));
	}



}
