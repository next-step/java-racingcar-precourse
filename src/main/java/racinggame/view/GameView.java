package racinggame.view;

import static racinggame.common.ViewMessage.*;

import nextstep.utils.Console;
import racinggame.controller.Host;

public class GameView {

	public void inputName(Host host) {
		System.out.println(MESSAGE_NAME_INPUT);
		String input = Console.readLine();
		try {
			host.setRacingCars(input);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			inputName(host);
		}
	}

	public void inputTryCount(Host host) {
		System.out.println(MESSAGE_TRY_INPUT);
		String input = Console.readLine();
		try {
			host.setTryCount(input);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			inputTryCount(host);
		}
	}

	public void outRacingResult(Host host) {
		System.out.println(MESSAGE_TRY_RESULT);
		System.out.println(host.getRacingResult());
	}

	public void outWinner(Host host) {
		System.out.printf(MESSAGE_WINNER_FORMAT, host.getWinner());
	}

	public void run() {
		Host host = new Host();
		inputName(host);
		inputTryCount(host);
		host.start();
		outRacingResult(host);
		outWinner(host);
	}
}
