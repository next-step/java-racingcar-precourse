package racinggame.model;

import java.util.Collections;

public class TotalTravel {
	private int totalTravel;

	public void moveForward() {
		totalTravel++;
	}
	
	public int get() {
		return totalTravel;
	}
	
	/**
	 * 진행상태를 '-'로 표시
	 * @return totalTravel 숫자만큼 '-' 문자가 반복되는 문자열
	 */
	public String getProgress() {
		return String.join("", Collections.nCopies(totalTravel, "-"));
	}
}
