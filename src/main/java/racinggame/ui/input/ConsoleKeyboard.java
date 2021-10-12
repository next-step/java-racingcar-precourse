package racinggame.ui.input;

import nextstep.utils.Console;
import racinggame.ui.InputDevice;

public class ConsoleKeyboard implements InputDevice {
	@Override
	public String input() {
		return Console.readLine();
	}
}
