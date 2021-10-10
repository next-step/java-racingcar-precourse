package racinggame.controller;

import racinggame.trycount.TryCount;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class TryCountInitController {

	private TryCountInitController() {
	}

	public static TryCount init() {
		TryCount tryCount = null;
		while (tryCount == null) {
			tryCount = createTryCount();
		}

		return tryCount;
	}

	private static TryCount createTryCount() {
		OutputView.printForAskingTryCountInput();

		try {
			return createTryCountByTryCount(InputView.getTryCountInput());
		} catch (RuntimeException e) {
			OutputView.printErrorMessage(e);
			return null;
		}
	}

	private static TryCount createTryCountByTryCount(int tryCountInput) {
		return new TryCount(tryCountInput);
	}
}
