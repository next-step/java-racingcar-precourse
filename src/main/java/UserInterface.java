import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserInterface {

	BufferedReader bufferedReader;

	public UserInterface() {
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * 자동차 이름 입력 값 받기
	 * @return 입력받은 차 이름(쉼표(,) 기준으로 구분)
	 */
	public String readAndInputValue(String message) throws Exception {
		String result;
		System.out.println(message);
		result = bufferedReader.readLine();
		return result;
	}

}
