package racinggame;

public class RacingContest {
	private RacingCars racingCars;
	private Rounds rounds;
	
	public RacingContest(RacingCars racingCars, Rounds rounds) {
		this.racingCars = racingCars;
		this.rounds = rounds;
	}
	
	public void start() {
		System.out.println("실행 결과");
		int round = rounds.getRound();
		while (round-- > 0) {
			racingCars.start();
			System.out.println("");
		}
	}
	
	public void announceWinner() {
		System.out.println("최종 우승자는 " + String.join(",", racingCars.getWinners()) + " 입니다.");
	}
}