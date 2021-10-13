package racinggame.machine.input;

import nextstep.utils.Console;
import racinggame.machine.InputDevice;

public final class ConsoleKeyboard implements InputDevice {
	@Override
	public String input() {
		return Console.readLine();
	}
}
