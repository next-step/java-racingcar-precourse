package racinggame;


import racinggame.controller.RacingDashboard;

public class Application {
    public static void main(String[] args) {
		RacingDashboard monitor = new RacingDashboard();
		monitor.startGame();
    }
}
