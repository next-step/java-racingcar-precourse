package racinggame.machine.output;

import racinggame.machine.OutputDevice;

public class ConsolePrinter implements OutputDevice {
	@Override
	public void print(String content) {
		System.out.println(content);
	}
}
