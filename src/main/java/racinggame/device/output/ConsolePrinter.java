package racinggame.device.output;

import racinggame.ui.OutputDevice;

public class ConsolePrinter implements OutputDevice {
	@Override
	public void print(String content) {
		System.out.println(content);
	}
}
