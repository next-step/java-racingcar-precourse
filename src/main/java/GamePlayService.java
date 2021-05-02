import java.util.Scanner;

public class GamePlayService {

	// 게임 시작
	public void startGame() {
		String[] carNameArr = new Cars(null).getCarNames();
		int playCount = getPlayCount();
	}

	// 1 이상인지 검증
	boolean isAboveMinimum(int playCount) {
		if (1 > playCount) {
			System.out.println("1이상의 숫자를 입력해 주세요.");
			return false;
		}
		return true;
	}

	// 숫자인지 검증
	boolean isNumber(String playCount) {
		try {
			return isAboveMinimum(Integer.parseInt(playCount));
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력해 주세요.");
			return false;
		}
	}

	// 레이싱 횟수 얻기
	int getPlayCount() {
		String playCount;
		do {
			System.out.println("시도할 회수는 몇 회인가요?");
			playCount = new Scanner(System.in).nextLine();
		} while (!isNumber(playCount));
		return Integer.parseInt(playCount);
	}

}
