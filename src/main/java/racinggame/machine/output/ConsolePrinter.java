package racinggame.machine.output;

import racinggame.machine.OutputDevice;

public final class ConsolePrinter implements OutputDevice {
	@Override
	public void print(final String content) {
		System.out.println(content);
	}
}
