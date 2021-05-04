package racing.game.domain.player;

import java.util.List;
import java.util.Scanner;

import racing.game.properties.RacingMessage;

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
			System.out.println(RacingMessage.INFO_SCAN_CAR_NAMES);
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
			System.out.println(RacingMessage.INFO_SCAN_LAP_COUNT);
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
