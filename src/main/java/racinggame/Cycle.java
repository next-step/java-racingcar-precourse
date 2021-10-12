package racinggame;

public class Cycle {
	private int cycle;

	private Cycle(int cycle) {
		this.cycle = cycle;
	}

	public static Cycle init(int cycle) {
		return new Cycle(cycle);
	}

	public int value() {
		return cycle;
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/11 12:05 오전
	 * @Description : 사용자의 입력값이 0 이상의 숫자인지 검증하는 메소드
	 *
	 **/
	public static boolean isMoreThanOne(String readLine) {
		try {
			return Integer.parseInt(readLine) > 0;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Cycle{" +
			"cycle=" + cycle +
			'}';
	}
}
