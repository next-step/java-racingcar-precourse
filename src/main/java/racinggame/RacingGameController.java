package racinggame;

import java.util.Optional;

public class RacingGameController {
	private final UserView userView;
	private final RacingGameView racingGameView;

	private Cars cars;
	private TryNumber tryNumber;

	public RacingGameController() {
		this.userView = new UserView();
		this.racingGameView = new RacingGameView();
	}

	public void play() {
		inputUserName();
		inputTryNumber();
	}

	private void inputUserName() {
		boolean isInvalid = true;
		while (isInvalid) {
			cars = new Cars(userView.inputCarNames());
			isInvalid = userView.showCarNamesErrorMsgIfInvalid(!cars.isValid());
		}
	}

	private void inputTryNumber() {
		boolean isInvalid = true;
		Optional<TryNumber> optionalTryNumber = Optional.empty();
		while (isInvalid) {
			optionalTryNumber = TryNumber.of(userView.inputTryNumber());
			isInvalid = userView.showTryNumberErrorMsgIfInvalid(!optionalTryNumber.isPresent());
		}
		tryNumber = optionalTryNumber.get();
	}
}
