package racingcar;

public class Round {
	private int count;

	public Round(int count) {
		validationOneOrMore(count);
		this.count = count;
	}

	private void validationOneOrMore(int count) {
		if (count < 1) {
			throw new IllegalArgumentException("1 이상의 수를 입력하세요.");
		}
	}

	public void reduceCount(){
		count--;
	}

	public boolean isEnd(){
		return count == 0;
	}

	public int getCount() {
		return count;
	}
}
