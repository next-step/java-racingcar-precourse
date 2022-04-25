package racingcar.model;

import racingcar.exception.CustomIllegalArgumentException;

public class Name {
	public static int MIN_NO = 1;
	public static int MAX_NO = 5;
	private String name;
	
	public Name(String name) {
		validateRange(name);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	private void validateRange(String name) {
		if(name.length()==0) {
			throw new CustomIllegalArgumentException("이름이 입력되지 않았습니다.");
		}
		if(name.length()>MAX_NO || name.length()<MIN_NO) {
			throw new CustomIllegalArgumentException("이름은 1자리에서 5자리 범위내에서 입력이 가능합니다.");
		}
	}
}
