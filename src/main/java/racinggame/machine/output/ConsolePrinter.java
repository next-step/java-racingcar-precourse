package racinggame.machine.output;

import racinggame.machine.OutputDevice;

public final class ConsolePrinter implements OutputDevice {
	@Override
	public void print(String content) {
		System.out.println(content);
	}
}
