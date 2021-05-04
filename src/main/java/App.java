public class App {
    public static void main(String[] args) {
        RacingCar game = new RacingCar();
        try {
			game.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
