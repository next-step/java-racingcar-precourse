package racinggame;

import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
    	try {
			Game game = new Game();
			game.init();
			game.play();
			game.finish();
		} catch (NoSuchElementException e) {
			System.out.println("[ERROR]");
			throw e;
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR]");
			throw e;
		} catch (Exception e) {
			System.out.println("[ERROR]");
			// throw e;
		}
    }
}
