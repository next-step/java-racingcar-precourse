package racinggame.domain;

public class Message {

	public void println(String message) {
		System.out.println(message);
	}

	public void lineBreak() {
		System.out.print("\n");
	}

	public void enterCarNam() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}

	public void enterEnterTryNumber() {
		System.out.println("시도할 회수는 몇회인가요?");
	}

	public void startDrive() {
		System.out.println("실행 결과");
	}

	public void printWinner(String winners) {
		System.out.println("최종 우승자는 "+ winners +" 입니다.");
	}

	public void printErrorCause(Exception exception) {
		System.out.println(exception.getMessage());
	}
}
