import utils.ScannerUtils;

public class GameMain {

	public static void main(String[] args) {
		Cars cars = new Cars(ScannerUtils.getRacingCarNameFromUser());
		int playNumber = ScannerUtils.getPlayNumberFromUser();

		System.out.println();
		System.out.println("실행 결과");

		for (int i = 0; i < playNumber; i++) {
			cars.playRacingGame();
			cars.showCurrentStatus();
			cars.setMax();
		}

		cars.showWinners();
	}

}
