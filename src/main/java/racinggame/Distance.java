package racinggame;

import racinggame.common.CommonCode;

public class Distance {
	private int numberValue;
	private String stringValue;

	public Distance() {
		numberValue = CommonCode.ZERO;
		stringValue = CommonCode.BLANK;
	}

	public int numberValue() {
		return this.numberValue;
	}

	public String stringValue() {
		return this.stringValue;
	}

	public void increase() {
		this.numberValue++;
		this.stringValue += CommonCode.BAR;
	}
}
