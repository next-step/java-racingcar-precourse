import java.util.Scanner;

public class GamePlayService {

	// 1 이상인지 검증
	boolean isAboveMinimum(int playCount) {
		if (1 > playCount) {
			System.out.println("1이상의 숫자를 입력해 주세요.");
			return false;
		}
		return true;
	}

}
