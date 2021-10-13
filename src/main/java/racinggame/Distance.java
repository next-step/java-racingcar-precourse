package racinggame;

public class Distance {
	private int numberValue;
	private String stringValue;

	public Distance() {
		numberValue = 0;
		stringValue = "";
	}

	public int numberValue() {
		return this.numberValue;
	}

	public String stringValue() {
		return this.stringValue;
	}

	public void increase() {
		this.numberValue++;
		this.stringValue += "-";
	}
}
