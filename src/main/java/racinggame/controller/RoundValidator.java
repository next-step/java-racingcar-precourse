package racinggame.controller;

public class RoundValidator {

	RoundValidator(){}

	public static boolean checkPipeline(String input) {
		try{
			isNotEmpty(input);
			isNumber(input);
			isOverOne(input);
			return true;
		} catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static void isNotEmpty(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException("[ERROR] - 빈 문자열 입력, 다시 입력해주세요 : ");
		}
	}

	public static void isNumber(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException("[ERROR] - 문자 입력, 다시 입력해주세요: ");
		}
	}

	public static void isOverOne(String input) {
		int number = Integer.parseInt(input);
		if (number < 1) {
			throw new IllegalArgumentException("[ERROR] - 1보다 작은 수 입력되었습니다. 다시 입력해주세요: ");
		}
	}

}
