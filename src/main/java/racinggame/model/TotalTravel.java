package racinggame.model;

import java.util.Collections;

public class TotalTravel {
	private int totalTravel;

	/**
	 * 자동차의 play 결과에 따라 이동
	 * @param result CarPlayResult 객체 - Car 클래스의 play 메소드로 획득
	 */
	public void move(CarPlayResult result) {
		if (result.isForward()) {
			totalTravel++;
		}
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
