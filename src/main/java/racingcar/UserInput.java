package racingcar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
	public static int inputMoveCount() {
		Scanner sc = new Scanner(System.in);
		int numbers;
		System.out.println("시도할 횟수 몇회인가요?");
		try {
			numbers = sc.nextInt();
		} catch (InputMismatchException exception) {
			System.out.println("숫자만 입력해주세요!");
			return -1;
		}
		return numbers;
	}

	public static String inputCarNames() {
		Scanner sc = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		return sc.next();
	}

	public static void main(String[] args) {
		System.out.println(UserInput.inputMoveCount());
		System.out.println(UserInput.inputCarNames());
	}
}
