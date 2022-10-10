package racingcar.util;

public class TextOutPut {
	private final StringBuffer buffer = new StringBuffer();

	public TextOutPut(String lines) {
		buffer.append(lines);
	}

	public TextOutPut(IllegalArgumentException lines) {
		printLines(lines);
	}

	public void printLines(String lines) {
		buffer.append(lines);
	}

	public void printLines(IllegalArgumentException lines) {
		buffer.append("[ERROR] ");
		buffer.append(lines);
	}

	public String flush() {
		String output = buffer.toString();
		buffer.setLength(0);
		return output;
	}
}
