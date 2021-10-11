package racinggame.view;

import static racinggame.common.ViewMessage.*;

import nextstep.utils.Console;
import racinggame.controller.Host;

public class GameView {

	public boolean inputName(Host host) {
		System.out.println(MESSAGE_NAME_INPUT);
		String input = Console.readLine();
		try {
			host.setRacingCars(input);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean inputTryCount(Host host) {
		System.out.println(MESSAGE_TRY_INPUT);
		String input = Console.readLine();
		try {
			host.setTryCount(Integer.valueOf(input));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public void outRacingResult(Host host) {
		System.out.println(MESSAGE_TRY_RESULT);
		String result = host.start();
		System.out.println(result);
	}

	public void outWinner(Host host) {
		System.out.printf(MESSAGE_WINNER_FORMAT, host.getWinner());
	}

	public void run() {
		Host host = new Host();
		boolean complete = false;
		while (!complete) {
			complete = inputName(host);
		}
		complete = false;
		while (!complete) {
			complete = inputTryCount(host);
		}
		outRacingResult(host);
		outWinner(host);
	}
}
