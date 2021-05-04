public class RunCarGame {

	public static void main(String[] args) {
		UserInterface userInterface = new UserInterface();
		try {
			String carNames = userInterface.readAndInputValue("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
			int raceCount = Integer.parseInt(userInterface.readAndInputValue("시도할 회수는 몇 회 인가요?"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
