package racinggame;

public class Rounds {
	private int round;
	
	public Rounds(String round) {
		validation(round);
		this.round = translateStringToInt(round);
	}
	
	private void validation(String round) {
		if (StringUtil.isEmpty(round)) {
			occurException();
		}
		if (round.startsWith("0")) {
			occurException();
		}
		
		int r = translateStringToInt(round);
		if (r < 1 || r > Integer.MAX_VALUE) {
			occurException();
		}
	}
	
	private void occurException() {
		System.out.println("[ERROR]횟수가 올바르지 않습니다");
		throw new IllegalArgumentException();
	}
	
	private int translateStringToInt(String round) {
		int r = 0;
		try {
			r = Integer.valueOf(round);
		} catch (NumberFormatException e) {
			occurException();
		}
		return r;
	}
	
	public int getRound() {
		return this.round;
	}
}
