package racing.game.domain;

public class RacingGameApplication {

	public static void run() {
		Player player = new Player();
		player.receiveName();
		player.receiveLapCount();

		Stadium stadium = new Stadium(player.getCarNameList(), player.getLapCount());
		stadium.startLap();
		stadium.chooseWinnerCars();
		stadium.showWinnerCar();
	}

	public static void main(String[] args) {
		run();
	}

}
