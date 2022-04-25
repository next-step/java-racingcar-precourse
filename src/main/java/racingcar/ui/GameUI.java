package racingcar.ui;

public interface GameUI {

	void process();

	boolean end();

	default void start() {
		while (true) {
			process();
			if (end())
				break;
		}
	}
}
