package view;

import java.util.List;

public class OutputView {
	public static void printResultMessage() {
		System.out.println("실행결과");
	}

	public static void printNewLine() {
		System.out.println("\n");
	}

	public static void printPosition(String Position) {
		System.out.println(Position);
	}

	public static void printCarName(String CarName) {
		System.out.print(CarName);
		System.out.print(" : ");
	}

	public static void printWinner(List<String> winners) {
		System.out.print(String.join(",", winners));
		System.out.println("가 최종 우승했습니다.");
	}
}
