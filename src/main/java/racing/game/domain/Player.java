package racing.game.domain;

import java.util.List;
import java.util.Scanner;

public class Player {

	private static Scanner scanner;
	private String inputedText;
	private List<String> carNameList;
	private ReceivedNames receivedNames;
	private ReceivedLapCount receivedLapCount;

	public Player() {
	}

	public void receiveName() {
		boolean keepGoing = true;
		while (keepGoing) {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			scanner = new Scanner(System.in);
			inputedText = scanner.nextLine();

			receivedNames = new ReceivedNames(inputedText);
			receivedNames.convertList();
			keepGoing = !receivedNames.isValidated();
		}
	}

	public void receiveLapCount() {
		boolean keepGoing = true;
		while (keepGoing) {
			System.out.println("시도할 회수는 몇회인가요?");
			scanner = new Scanner(System.in);
			inputedText = scanner.nextLine();

			receivedLapCount = new ReceivedLapCount(inputedText);
			keepGoing = !receivedLapCount.isValidated();
		}
	}

	public List<String> getCarNameList() {
		return receivedNames.getSplittedTextList();
	}

	public int getLapCount() {
		return receivedLapCount.getLapCount();
	}

}
