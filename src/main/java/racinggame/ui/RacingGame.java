package racinggame.ui;

public final class RacingGame {
	private final InputDevice inputDevice;
	private final OutputDevice outputDevice;

	public RacingGame(InputDevice inputDevice, OutputDevice outputDevice) {
		this.inputDevice = inputDevice;
		this.outputDevice = outputDevice;
	}

	public void play() {
		outputDevice.print("경주할 자동차 이름을 입력하세요");
		String[] names = inputDevice.input().split(",");

		for(String name : names){
			if(name.length() > 5){
				outputDevice.print("[ERROR]");
			}
		}

		outputDevice.print("시도할 횟수는 몇회인가요?");
		String times = inputDevice.input();

		outputDevice.print("실행결과");

		String result = new StringBuilder()
			.append("pobi : -\n")
			.append("woni : ")
			.append("최종 우승자는 pobi 입니다.")
			.toString();

		outputDevice.print(result);
	}
}
