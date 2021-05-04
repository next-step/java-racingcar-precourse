package view;

import java.util.ArrayList;
import java.util.List;

import domain.car.Position;
import domain.car.result.CarMoveResult;
import domain.car.result.CarMoveResults;
import domain.car.winner.Winner;
import domain.car.winner.Winners;

public class OutputView {

	public static final String ICON = "-";
	public static final String WINNER_DELIITER = ", ";

	public static void printWinners(Winners winners) {
		System.out.printf("%s가 최종 우승했습니다.", makeWinnerNames(winners));
	}

	public static void printAllResult(List<CarMoveResults> allResult) {
		System.out.println("실행 결과");

		for (CarMoveResults results : allResult) {
			for (CarMoveResult carMoveResult : results.getCarMoveResults()) {
				System.out.printf("%s : %s\n", carMoveResult.getCarName(), makeIcon(carMoveResult.getPosition()));
			}

			System.out.println();
		}
	}

	private static String makeWinnerNames(Winners winners) {
		List<String> winnerStrs = new ArrayList<>();

		for (Winner winner : winners.getWinners()) {
			winnerStrs.add(winner.getCarName().toString());
		}

		return String.join(WINNER_DELIITER, winnerStrs);
	}

	private static String makeIcon(Position position) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < position.getValue(); i++) {
			stringBuilder.append(ICON);
		}
		return stringBuilder.toString();
	}
}
