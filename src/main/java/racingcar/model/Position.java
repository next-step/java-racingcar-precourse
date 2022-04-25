package racingcar.model;

import racingcar.exception.CustomIllegalArgumentException;

public class Position {
	private int position;
	
	public Position(int position) {
		validateRange(position);
		this.position = position;
	}
	
	public int getPosition() {
		return position;
	}
	
	private void validateRange(int position) {
		if(position < 0) {
			throw new CustomIllegalArgumentException("차의 위치값은 0이상의 숫자만 입력할 수 있습니다.");
		}
	}
	
	public void move(CarStatus carStatus) {
		if(carStatus.isGo()) {
			position++;	
		}
	}
}
