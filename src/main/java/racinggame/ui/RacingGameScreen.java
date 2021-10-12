package racinggame.ui;

import racinggame.ui.config.RacingGameConfig;
import racinggame.ui.input.ConsoleKeyboard;
import racinggame.ui.output.ConsolePrinter;

public final class RacingGameScreen {
	private Settings settings;

	public void on() {
		gameSetting();
	}

	private void gameSetting() {
		settings = new RacingGameConfig(
			new ConsoleKeyboard(),
			new ConsolePrinter())
			.configGame();
	}
}
