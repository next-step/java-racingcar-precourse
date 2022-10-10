package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public abstract class Input<T> {
	private T target;
	private boolean retry;

	public T read() {
		do {
			tryRead();
		} while (retry);
		return this.target;
	}

	private void tryRead() {
		try {
			System.out.println(message());
			String input = Console.readLine();
			this.target = generate(input);
			this.retry = false;
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] " + e.getMessage());
			this.retry = true;
		}
	}

	abstract String message();

	abstract T generate(String input);
}
